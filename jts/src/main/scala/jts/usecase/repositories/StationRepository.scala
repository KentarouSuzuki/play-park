package jts.usecase.repositories

import core.usecase.repositories.AbstractStationRepository
import jts.domain.Station
import org.locationtech.jts.geom.Geometry
import org.locationtech.jts.io.WKBReader
import scalikejdbc.WrappedResultSet

object StationRepository extends AbstractStationRepository[Station]{
  def readWKB(wkb: Array[Byte]): Geometry = {
    val reader = new WKBReader()
    reader.read(wkb)
  }

  override def extract(rs: WrappedResultSet, n: scalikejdbc.ResultName[Station]): Station = new Station(
    id = rs.int(n.id),
    name = rs.string(n.name),
    geom = readWKB(rs.bytes(n.geom))
  )
}
