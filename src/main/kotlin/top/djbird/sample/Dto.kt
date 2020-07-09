package top.djbird.sample

data class LocationDto (
    val id: Long,
    val location: Location,
    val createAt: String
)

data class Location (
    val longitude: Double,
    val latitude: Double
)