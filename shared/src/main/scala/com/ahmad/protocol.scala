package com.ahmad

import sttp.tapir.infallibleEndpoint

object protocol {
  import sttp.tapir._
  import sttp.tapir.json.circe._
  import sttp.tapir.generic.auto._

  private val base = infallibleEndpoint.in("api")

  val build: Endpoint[Unit, Build, Nothing, Hash, Any] = base
    .put
    .in("build")
    .in(jsonBody[Build])
    .out(jsonBody[Hash])

  val run: Endpoint[Unit, Hash, Nothing, SystemState, Any] = base
    .post
    .in("run")
    .in(jsonBody[Hash])
    .out(jsonBody[SystemState])

}
