package pbs.pai.ala_pyszne.core.usecase

import pbs.pai.ala_pyszne.core.domain.Restaurant
import pbs.pai.ala_pyszne.core.expose.RestaurantData
import pbs.pai.ala_pyszne.core.require.RestaurantRepository
import java.util.UUID

class RestaurantUseCase(
    private val repository: RestaurantRepository
) {
    fun addRestaurant(restaurantData: RestaurantData): Restaurant =
        repository.save(
            Restaurant(
                UUID.randomUUID().toString(),
                restaurantData.name,
                restaurantData.description,
                restaurantData.address,
                restaurantData.openedFrom,
                restaurantData.openedTo,
                restaurantData.menuItems
            )
        )
    fun updateRestaurant(restaurantId: String, restaurantData: RestaurantData): Restaurant? {
        return repository.update(
            Restaurant(
                restaurantId,
                restaurantData.name,
                restaurantData.description,
                restaurantData.address,
                restaurantData.openedFrom,
                restaurantData.openedTo,
                restaurantData.menuItems
            )
        )
    }

    fun getAll(): List<Restaurant> {
        return repository.findAll()
    }

}