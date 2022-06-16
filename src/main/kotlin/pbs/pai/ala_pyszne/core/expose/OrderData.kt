package pbs.pai.ala_pyszne.core.expose

import pbs.pai.ala_pyszne.core.domain.*
import java.time.LocalDateTime

data class OrderData(
    val restaurantId:String,
    val customerData: CustomerData,
    val destination: Address,
    val menuItemIdAndAmount: Map<String,Int>
)
