package jts.domain

import org.locationtech.jts.geom.Geometry

class Station(
             id: Int,
             name: String,
             geom: Geometry
             ) extends AbstractStation(id, name)
