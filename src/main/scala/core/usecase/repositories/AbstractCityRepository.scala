package core.usecase.repositories

import core.infrastructure.PostgreSQL

trait AbstractCityRepository[A] extends PostgreSQL[A] {
  override lazy val defaultAlias = createAlias("c")

  override def tableName: String = "city"
  override def columns = Seq("id", "code", "pref", "name", "population", "geom")
}
