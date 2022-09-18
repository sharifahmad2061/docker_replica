package com.ahmad

import com.ahmad.Build.apply

enum Command {
  case Build(build: com.ahmad.Build)
  case Run(hash: Hash)
}

final case class Build(
  base: Build.Base,
  commands: List[Build.Command],
)

object Build {

  enum Base {
    case emptyImage
    case Image(hash: Hash)
  }

  enum Command {
    case Upsert(key: String, value: String)
    case Delete(key: String)
  }

  def empty: Build = Build(Base.emptyImage, Nil)

}

final case class Hash(value: Array[Byte])
final case class SystemState(getAll: Map[String, String])
