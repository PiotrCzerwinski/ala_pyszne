package pbs.pai.ala_pyszne.outbound.mongo

import pbs.pai.ala_pyszne.core.domain.Restaurant
import pbs.pai.ala_pyszne.core.domain.require.RestaurantRepository

class MongoRestaurantRepository(private val repository: MongoEntityRestaurantRepository) : RestaurantRepository {
    override fun save(restaurant: Restaurant): Restaurant =
        repository.save(restaurant)

    override fun update(restaurant: Restaurant): Restaurant {
        val original = repository.findById(restaurant.id).get()
        return repository.save(
            original.copy(
                name = restaurant.name,
                description = restaurant.description,
                address = restaurant.address,
                openedFrom = restaurant.openedFrom,
                openedTo = restaurant.openedTo,
                menuItems = restaurant.menuItems
            )
        )

    }
}