package pbs.pai.ala_pyszne.core.domain

import java.time.LocalDateTime

data class Order(
    val id: String,
    val customer: Customer,
    val restaurantId: String,
    val orderedAt: LocalDateTime,
    val destination: Address,
    val items: List<MenuItem>,
    val totalCost: Double,
    val deliveryManNumber: String,
    val orderStatus: OrderStatus

)
