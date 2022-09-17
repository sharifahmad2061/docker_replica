package com.ahmad

trait Executor[F[_]] {
  def build(build: Build): F[Hash]
  def run(hash: Hash): F[SystemState]
}

object Executor {
  def apply[F[_]](using F: Executor[F]): Executor[F] = F

  def instance[F[_]]: Executor[F] =
    new Executor[F] {
      private val empty: Hash = Hash(Array.emptyByteArray)
      def build(build: Build): F[Hash] = ???
      def run(hash: Hash): F[SystemState] = ???
    }

  private final case class KVState(state: Map[String, String])

}

trait SystemState {
  def getAll: Map[String, String]
}
