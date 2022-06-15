package pbs.pai.ala_pyszne.outbound.mongo

import org.springframework.data.repository.findByIdOrNull
import pbs.pai.ala_pyszne.core.domain.Restaurant
import pbs.pai.ala_pyszne.core.expose.RestaurantData
import pbs.pai.ala_pyszne.core.require.RestaurantRepository

class MongoRestaurantRepository(
    private val repository: MongoEntityRestaurantRepository
    ) : RestaurantRepository {

    override fun save(restaurant: Restaurant): Restaurant =
        repository.save(restaurant)

    override fun updateInfo(restaurantId: String, restaurantData: RestaurantData): Restaurant? =
        repository.findByIdOrNull(restaurantId)?.copy(
                name = restaurantData.name,
                description = restaurantData.description,
                address = restaurantData.address,
                openedFrom = restaurantData.openedFrom,
                openedTo = restaurantData.openedTo
            )?.let(::save)

    override fun findAll(): List<Restaurant> =
        repository.findAll()

    override fun findById(restaurantId: String): Restaurant? =
        repository.findByIdOrNull(restaurantId)

}