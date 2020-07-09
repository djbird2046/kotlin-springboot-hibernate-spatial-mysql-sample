package top.djbird.sample

import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.GeometryFactory
import org.locationtech.jts.geom.Point
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "tb_location")
data class LocationDao (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = -1,

    var location: Point = GeometryFactory().createPoint(Coordinate(0.0, 0.0)),

    var createAt: LocalDateTime = LocalDateTime.now()
)