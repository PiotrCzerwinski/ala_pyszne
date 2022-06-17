package pbs.pai.ala_pyszne.outbound.mongo

import org.springframework.data.repository.findByIdOrNull
import pbs.pai.ala_pyszne.core.domain.MenuItem
import pbs.pai.ala_pyszne.core.expose.MenuItemData
import pbs.pai.ala_pyszne.core.require.MenuItemRepository
import java.util.UUID

class MongoMenuItemRepository(
    private val menuItemRepository: MongoEntityMenuItemRepository,
): MenuItemRepository {
    override fun addMenuItem(menuItemData: MenuItemData): MenuItem =
        menuItemRepository.save(
            MenuItem(
                UUID.randomUUID().toString(),
                menuItemData.name,
                menuItemData.price,
                menuItemData.ingredients
            )
        )
    override fun updateMenuItem(menuItemId: String, menuItemData: MenuItemData): MenuItem? =
        menuItemRepository.findByIdOrNull(menuItemId)
            ?.copy(
                name = menuItemData.name,
                price = menuItemData.price,
                ingredients = menuItemData.ingredients
        )?.let { menuItemRepository.save(it)}


    override fun removeMenuItem(menuItemId: String) {
        menuItemRepository.deleteById(menuItemId)
    }

    override fun findByIds(ids: Set<String>): List<MenuItem> =
        menuItemRepository.findByIdIn(ids)

}