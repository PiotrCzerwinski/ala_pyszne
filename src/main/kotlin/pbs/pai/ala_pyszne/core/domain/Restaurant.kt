package pbs.pai.ala_pyszne.core.domain

import java.time.LocalTime

data class Restaurant(
    val id: String,
    val name: String,
    val description: String,
    val address: Address,
    val openedFrom: LocalTime,
    val openedTo: LocalTime,
    val menuItems: List<MenuItem>
)
