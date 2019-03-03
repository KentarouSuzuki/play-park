package jts.domain

import org.locationtech.jts.geom.Geometry

class City(
            id: Int,
            code: String,
            pref: String,
            name: String,
            population: Int,
            geom: Geometry
          ) extends AbstractCity(id, code, pref, name, population)
