package com.ahmad

import java.util.concurrent.Executor

object ClientSideExecutor {

  def instance[F[_]]: Executor[F] =
    new Executor[F] {
      def build(build: Build): F[Hash] = ???
      def run(hash: Hash): F[SystemState] = ???
    }

}
