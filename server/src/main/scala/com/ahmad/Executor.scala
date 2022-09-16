package com.ahmad

trait Executor[F[_]] {
  def build(build: Build): F[Hash]
  def run(hash: Hash): F[Unit]
}

object Executor {
  def apply[F[_]](using F: Executor[F]): Executor[F] = F

  def instance[F[_]]: Executor[F] =
    new Executor[F] {
      private val empty: Hash = Hash(Array.emptyByteArray)
      def build(build: Build): F[Hash] = ???
      def run(hash: Hash): F[Unit] = ???
    }

}