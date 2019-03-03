package core.usecase.repositories

import core.infrastructure.PostgreSQL

trait AbstractStationRepository[A] extends PostgreSQL[A] {
  override lazy val defaultAlias = createAlias("s")

  override def tableName: String = "station"
  override def columns = Seq("id", "name", "geom")
}
