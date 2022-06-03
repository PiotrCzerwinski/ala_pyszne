package pbs.pai.ala_pyszne.core.domain

data class Address(
    val city: String,
    val street: String,
    val buildingNumber: String,
    val flatNumber: String?
)
