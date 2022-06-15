package pbs.pai.ala_pyszne.outbound.mongo

import org.springframework.data.repository.findByIdOrNull
import pbs.pai.ala_pyszne.core.domain.MenuItem
import pbs.pai.ala_pyszne.core.expose.MenuItemData
import pbs.pai.ala_pyszne.core.require.MenuItemRepository
import java.util.UUID

class MongoMenuItemRepository(
    private val repository: MongoEntityMenuItemRepository
): MenuItemRepository {
    override fun addMenuItem(menuItemData: MenuItemData): MenuItem =
        repository.save(
            MenuItem(
                UUID.randomUUID().toString(),
                menuItemData.name,
                menuItemData.price,
                menuItemData.ingredients
            )
        )
    override fun updateMenuItem(menuItemId: String, menuItemData: MenuItemData): MenuItem? =
        repository.findByIdOrNull(menuItemId)
            ?.copy(
                name = menuItemData.name,
                price = menuItemData.price,
                ingredients = menuItemData.ingredients
        )?.let { repository.save(it)}


    override fun removeMenuItem(menuItemId: String) {
        repository.deleteById(menuItemId)
    }
}