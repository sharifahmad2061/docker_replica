val Versions =
  new {
    val tapir = "1.0.6"
    val http4s = "0.23.16"
  }

ThisBuild / scalaVersion := "3.1.3"
ThisBuild / versionScheme := Some("early-semver")
ThisBuild / githubWorkflowPublishTargetBranches := Seq()

val commonSettings = Seq(
  scalacOptions -= "-Xfatal.warnings",
  libraryDependencies ++= Seq(
    "org.typelevel" %% "cats-effect" % "3.3.14",
    "org.typelevel" %% "munit-cats-effect-3" % "1.0.7",
  ),
)

val shared = project.settings(
  commonSettings,
  libraryDependencies ++= Seq(
    "com.softwaremill.sttp.tapir" %% "tapir-core" % Versions.tapir,
    "com.softwaremill.sttp.tapir" %% "tapir-json-circe" % Versions.tapir,
  ),
)

val server = project
  .settings(
    commonSettings,
    libraryDependencies ++= Seq(
      "com.softwaremill.sttp.tapir" %% "tapir-http4s-server" % Versions.tapir,
      "org.http4s" %% "http4s-dsl" % Versions.http4s,
      "org.http4s" %% "http4s-ember-server" % Versions.http4s,
    ),
  )
  .dependsOn(shared)

val client = project.settings(commonSettings).dependsOn(shared)

val root = project
  .in(file("."))
  .settings(publish := {}, publish / skip := true)
  .aggregate(client, server, shared)
