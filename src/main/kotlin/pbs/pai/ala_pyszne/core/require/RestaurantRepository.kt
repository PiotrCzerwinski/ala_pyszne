package pbs.pai.ala_pyszne.core.require

import pbs.pai.ala_pyszne.core.domain.Restaurant
import pbs.pai.ala_pyszne.core.expose.RestaurantData

interface RestaurantRepository {

    fun save(restaurant: Restaurant): Restaurant
    fun updateInfo(restaurantId: String, restaurantData: RestaurantData): Restaurant?
    fun findAll(): List<Restaurant>
    fun findById(restaurantId: String): Restaurant?
}