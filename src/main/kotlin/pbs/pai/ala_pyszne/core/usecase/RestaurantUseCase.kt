package pbs.pai.ala_pyszne.core.usecase

import pbs.pai.ala_pyszne.core.domain.MenuItem
import pbs.pai.ala_pyszne.core.domain.Restaurant
import pbs.pai.ala_pyszne.core.expose.MenuItemData
import pbs.pai.ala_pyszne.core.expose.RestaurantData
import pbs.pai.ala_pyszne.core.require.MenuItemRepository
import pbs.pai.ala_pyszne.core.require.RestaurantRepository
import java.util.UUID

class RestaurantUseCase(
    private val restaurantRepository: RestaurantRepository,
    private val menuItemRepository: MenuItemRepository
) {
    fun addRestaurant(restaurantData: RestaurantData): Restaurant =
        restaurantRepository.save(
            Restaurant(
                UUID.randomUUID().toString(),
                restaurantData.name,
                restaurantData.description,
                restaurantData.address,
                restaurantData.openedFrom,
                restaurantData.openedTo,
                restaurantData.menuItems
                    .map {
                        MenuItem(
                            UUID.randomUUID().toString(),
                            it.name,
                            it.price,
                            it.ingredients
                        )
                    }.onEach { menuItem ->
                        menuItemRepository.addMenuItem(menuItem.data())
                    }
            )
        )

    fun updateRestaurantInfo(restaurantId: String, restaurantData: RestaurantData): Restaurant? =
        restaurantRepository.updateInfo(restaurantId, restaurantData)

    fun getAll(): List<Restaurant> {
        return restaurantRepository.findAll()
    }

    fun addMenuItem(restaurantId: String, menuItemData: MenuItemData) {
        restaurantRepository.findById(restaurantId)
            ?.let {
                val items: MutableList<MenuItem> = it.menuItems as MutableList<MenuItem>
                items.add(
                    menuItemRepository.addMenuItem(menuItemData)
                )
                restaurantRepository.save(it.copy(menuItems = items))

            }
    }

    fun deleteMenuItem(restaurantId: String, menuItemId: String) {
        restaurantRepository.findById(restaurantId)?.let {
            val items: MutableList<MenuItem> = it.menuItems as MutableList<MenuItem>
            items.removeIf { item -> item.id == menuItemId }
            menuItemRepository.removeMenuItem(menuItemId)
            restaurantRepository.save(
                it.copy(
                    menuItems = items
                )
            )
        }
    }

    fun updateMenuItem(restaurantId: String, menuItemId: String, menuItemData: MenuItemData) {
        restaurantRepository.findById(restaurantId)?.let {
            val foundItem = menuItemRepository.updateMenuItem(menuItemId,menuItemData)
            if(foundItem != null) {
                val items: MutableList<MenuItem> = it.menuItems as MutableList<MenuItem>
                items.removeIf { item -> item.id == menuItemId }
                items.add(foundItem)
                menuItemRepository.removeMenuItem(menuItemId)
                restaurantRepository.save(
                    it.copy(
                        menuItems = items
                    )
                )
            }
        }
    }

}