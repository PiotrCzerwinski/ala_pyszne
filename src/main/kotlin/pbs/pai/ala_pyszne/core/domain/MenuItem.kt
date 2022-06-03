package pbs.pai.ala_pyszne.core.domain

data class MenuItem(
    val name: String,
    val price: Double,
    val ingredients: List<Ingredient>
)
