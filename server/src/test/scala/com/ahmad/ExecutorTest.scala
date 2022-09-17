package com.ahmad

import munit.CatsEffectSuite
import cats.Id

class ExecutorTest extends CatsEffectSuite {
  val exec = Executor.instance[Either[Throwable, *]]

  test("Build Empty Image") {
    val hash = exec.build(Build.empty)
    assertEquals(
      exec.build(Build.empty).flatMap(exec.run).map(_.getAll),
      Right(Map.empty),
    )
  }
}
