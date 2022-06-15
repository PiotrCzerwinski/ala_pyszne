package pbs.pai.ala_pyszne.core.domain

import pbs.pai.ala_pyszne.core.expose.MenuItemData
import pbs.pai.ala_pyszne.core.expose.RestaurantData
import java.time.LocalTime

data class Restaurant(
    val id: String,
    val name: String,
    val description: String,
    val address: Address,
    val openedFrom: LocalTime,
    val openedTo: LocalTime,
    val menuItems: List<MenuItem>
){

    fun data() = RestaurantData(
            name,
            description,
            address,
            openedFrom,
            openedTo,
            menuItems.map{
                MenuItemData(
                    it.name,
                    it.price,
                    it.ingredients
                )
            }
        )

}
