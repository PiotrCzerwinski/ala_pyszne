package pbs.pai.ala_pyszne.core.expose

import pbs.pai.ala_pyszne.core.domain.Address
import java.time.LocalTime

data class RestaurantData(
    val name: String,
    val description: String,
    val address: Address,
    val openedFrom: LocalTime,
    val openedTo: LocalTime,
    val menuItems: List<MenuItemData>
)
