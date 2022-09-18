package com.ahmad

import io.circe.Codec

enum Command {
  case Build(build: com.ahmad.Build)
  case Run(hash: Hash)
}

final case class Build(
  base: Build.Base,
  commands: List[Build.Command],
) derives Codec.AsObject

object Build {

  enum Base derives Codec.AsObject {
    case emptyImage
    case Image(hash: Hash)
  }

  enum Command derives Codec.AsObject {
    case Upsert(key: String, value: String)
    case Delete(key: String)
  }

  def empty: Build = Build(Base.emptyImage, Nil)

}

final case class Hash(value: Array[Byte]) derives Codec.AsObject
final case class SystemState(getAll: Map[String, String]) derives Codec.AsObject
