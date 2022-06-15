package pbs.pai.ala_pyszne.inbound.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import pbs.pai.ala_pyszne.core.domain.MenuItem
import pbs.pai.ala_pyszne.core.domain.Restaurant
import pbs.pai.ala_pyszne.core.expose.MenuItemData
import pbs.pai.ala_pyszne.core.expose.RestaurantData
import pbs.pai.ala_pyszne.core.usecase.RestaurantUseCase

@RestController
class RestuarantController(
    private val restaurantUseCase: RestaurantUseCase
) {
    @GetMapping("/restaurants")
    fun getAllRestaurants(): ResponseEntity<List<Restaurant>> =
        ResponseEntity(restaurantUseCase.getAll(), HttpStatus.OK)

    @PostMapping("/restaurants/add")
    fun addRestaurant(@RequestBody restaurantData: RestaurantData): ResponseEntity<Restaurant> =
        ResponseEntity(restaurantUseCase.addRestaurant(restaurantData), HttpStatus.OK)

    @PutMapping("/restaurants/{id}")
    fun updateRestaurant(
        @PathVariable id: String,
        @RequestBody restaurantData: RestaurantData
    ): ResponseEntity<Restaurant> {
        val updated = restaurantUseCase.updateRestaurantInfo(id, restaurantData)
        return if (updated != null) ResponseEntity(updated, HttpStatus.OK) else ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PostMapping("/restaurants/add_menu_item/{id}")
    fun addMenuItem(@PathVariable id: String, @RequestBody menuItemData: MenuItemData)
            : ResponseEntity<HttpStatus> {
        restaurantUseCase.addMenuItem(id, menuItemData)
        return ResponseEntity(HttpStatus.OK)
    }

    @PutMapping("/restaurants/update_menu_item/{restaurantId}/{menuItemId}")
    fun updateMenuItem(
        @PathVariable restaurantId: String,
        @PathVariable menuItemId: String,
        @RequestBody menuItemData: MenuItemData
    ): ResponseEntity<HttpStatus> {
        restaurantUseCase.updateMenuItem(restaurantId, menuItemId, menuItemData)
        return ResponseEntity(HttpStatus.OK)
    }

    @DeleteMapping("/restaurants/delete_menu_item/{restaurantId}/{menuItemId}")
    fun deleteMenuItem(@PathVariable restaurantId: String, @PathVariable menuItemId: String
    ): ResponseEntity<HttpStatus> {
        restaurantUseCase.deleteMenuItem(restaurantId, menuItemId)
        return ResponseEntity(HttpStatus.OK)
    }
}