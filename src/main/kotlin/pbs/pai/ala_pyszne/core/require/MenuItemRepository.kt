package pbs.pai.ala_pyszne.core.require

import pbs.pai.ala_pyszne.core.domain.MenuItem
import pbs.pai.ala_pyszne.core.expose.MenuItemData

interface MenuItemRepository {

    fun addMenuItem(menuItemData: MenuItemData): MenuItem
    fun updateMenuItem(menuItemId: String, menuItemData: MenuItemData): MenuItem?
    fun removeMenuItem(menuItemId: String)
}