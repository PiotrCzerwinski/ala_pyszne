package pbs.pai.ala_pyszne.core.domain

import pbs.pai.ala_pyszne.core.expose.MenuItemData

data class MenuItem(
    val id: String,
    val name: String,
    val price: Double,
    val ingredients: List<Ingredient>
){
    fun data()= MenuItemData(
        name,
        price,
        ingredients
    )
}
