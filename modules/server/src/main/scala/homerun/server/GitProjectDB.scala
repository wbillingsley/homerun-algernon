package homerun.server

import doobie._
import doobie.h2._
import doobie.implicits._

import cats._
import cats.effect._
import cats.implicits._

// We're only processing requests from the local user. We should be ok keeping it simple.
import cats.effect.unsafe.implicits.global

val gitProjectsTransactor =
  Transactor.fromDriverManager[IO](
    "org.h2.Driver",
    "jdbc:h2:~/.homerun/gitprojects;DB_CLOSE_DELAY=-1", // connect URL
  )


val createGitProjectTables = 
  sql"""
    CREATE TABLE gitprojects(
      id  SERIAL,
      origin  VARCHAR NOT NULL,
      name  VARCHAR NOT NULL,
      remote  VARCHAR NOT NULL,
      hash  VARCHAR NOT NULL,
      head  VARCHAR,
      filepath  VARCHAR
    )
  """

case class GitProject(
  id:Int, pageOrigin:String, 
  name:String, remoteUrl:String, hash:String, head:Option[String], filePath:Option[String]
)

