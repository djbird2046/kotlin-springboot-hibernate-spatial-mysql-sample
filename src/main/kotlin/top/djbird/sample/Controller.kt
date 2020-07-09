package top.djbird.sample

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/location")
class LocationController(private val locationService: LocationService) {
    @GetMapping("")
    fun fetchLocationList(): List<LocationDto> = locationService.fetchAll()

    @PostMapping("")
    fun addOne(@RequestBody locationForm: LocationForm): LocationDto = locationService.addOne(locationForm)
}