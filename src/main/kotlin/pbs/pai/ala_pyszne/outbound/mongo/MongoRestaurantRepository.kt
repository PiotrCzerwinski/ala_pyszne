package pbs.pai.ala_pyszne.outbound.mongo

import org.springframework.data.domain.Page
import org.springframework.data.repository.findByIdOrNull
import pbs.pai.ala_pyszne.core.domain.Restaurant
import pbs.pai.ala_pyszne.core.require.RestaurantRepository

class MongoRestaurantRepository(private val repository: MongoEntityRestaurantRepository) : RestaurantRepository {
    override fun save(restaurant: Restaurant): Restaurant =
        repository.save(restaurant)

    override fun update(restaurant: Restaurant): Restaurant? =
        repository.findByIdOrNull(restaurant.id)?.copy(
                name = restaurant.name,
                description = restaurant.description,
                address = restaurant.address,
                openedFrom = restaurant.openedFrom,
                openedTo = restaurant.openedTo,
                menuItems = restaurant.menuItems
            )?.let(::save)

    override fun findAll(): List<Restaurant> =
        repository.findAll()

}