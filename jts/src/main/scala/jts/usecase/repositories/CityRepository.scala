package jts.usecase.repositories

import core.usecase.repositories.AbstractCityRepository
import jts.domain.City
import org.locationtech.jts.io.WKBReader
import org.locationtech.jts.geom.Geometry
import scalikejdbc.WrappedResultSet

object CityRepository extends AbstractCityRepository[City] {
  def readWKB(wkb: Array[Byte]): Geometry = {
    val reader = new WKBReader()
    reader.read(wkb)
  }

  override def extract(rs: WrappedResultSet, n: scalikejdbc.ResultName[City]): City = new City(
    id = rs.int(n.id),
    code = rs.string(n.code),
    pref = rs.string(n.pref),
    name = rs.string(n.name),
    population = rs.int(n.population),
    geom = readWKB(rs.bytes(n.geom))
  )

}
