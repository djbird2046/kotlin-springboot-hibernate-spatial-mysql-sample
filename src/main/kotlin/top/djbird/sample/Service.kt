package top.djbird.sample

import org.locationtech.jts.geom.Coordinate
import org.locationtech.jts.geom.GeometryFactory
import org.springframework.stereotype.Service

@Service
class LocationService(private val locationRepository: LocationRepository) {
    fun fetchAll(): List<LocationDto> = locationRepository.findAll().map { it.toDto() }

    fun addOne(locationForm: LocationForm): LocationDto = locationRepository.save(locationForm.toDao()).toDto()
}

fun LocationDao.toDto() = LocationDto(id, Location(location.coordinate.x, location.coordinate.y), createAt.toString())
fun LocationForm.toDao() = LocationDao(location = GeometryFactory().createPoint(Coordinate(longitude, latitude)))