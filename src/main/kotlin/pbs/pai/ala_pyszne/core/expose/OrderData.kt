package pbs.pai.ala_pyszne.core.expose

import pbs.pai.ala_pyszne.core.domain.*
import java.time.LocalDateTime

data class OrderData(
    val customerData: CustomerData,
    val fromRestaurant: Restaurant,
    val orderedAt: LocalDateTime,
    val destination: Address,
    val items: List<MenuItem>
)
