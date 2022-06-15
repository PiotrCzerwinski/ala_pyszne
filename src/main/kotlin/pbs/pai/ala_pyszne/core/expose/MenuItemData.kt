package pbs.pai.ala_pyszne.core.expose

import pbs.pai.ala_pyszne.core.domain.Ingredient

data class MenuItemData(
    val name: String,
    val price: Double,
    val ingredients: List<Ingredient>
)
