package com.ahmad

import munit.CatsEffectSuite
import cats.Id

class ServerSideExecutorTest extends CatsEffectSuite {
  val exec = ServerSideExecutor.instance[Either[Throwable, *]]

  test("Build Empty Image") {
    val hash = exec.build(Build.empty)
    assertEquals(
      exec.build(Build.empty).flatMap(exec.run).map(_.getAll),
      Right(Map.empty),
    )
  }
}
