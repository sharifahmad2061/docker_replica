package com.ahmad

import munit.CatsEffectSuite
import cats.Id

class ExecutorTest extends CatsEffectSuite {
  val exec = Executor.instance[Id]

  test("Build Empty Image") {
    val hash = exec.build(Build.empty)
    assertEquals(
      exec.run(hash).getAll,
      Map.empty,
    )
  }
}
