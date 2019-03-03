package core.infrastructure

import scalikejdbc._
import core.interfaces.CRUDMapper

trait PostgreSQL[A] extends CRUDMapper[A] {
  val host = "localhost"
  val port = 5432
  val database = "sample"
  val user = "suzukikentarou"
  val password = ""

  val url = s"jdbc:postgresql://$host:$port/$database"

  ConnectionPool.singleton(url, user, password)

}
