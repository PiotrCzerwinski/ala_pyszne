package pbs.pai.ala_pyszne.core.usecase

import pbs.pai.ala_pyszne.core.domain.Customer
import pbs.pai.ala_pyszne.core.domain.Order
import pbs.pai.ala_pyszne.core.domain.OrderStatus
import pbs.pai.ala_pyszne.core.expose.OrderData
import pbs.pai.ala_pyszne.core.require.OrderRepository
import java.time.LocalDateTime
import java.util.*
import kotlin.random.Random
import kotlin.random.nextInt

class OrderUseCase(
    private val repository: OrderRepository
) {
    fun createOrder(orderData: OrderData): Order =
        repository.save(
            Order(
                UUID.randomUUID().toString(),
                Customer(
                    UUID.randomUUID().toString(),
                    orderData.customerData.name,
                    orderData.customerData.surname,
                    orderData.customerData.phoneNumber,
                    orderData.customerData.email,
                ),
                orderData.fromRestaurant,
                LocalDateTime.now(),
                orderData.destination,
                orderData.items,
                orderData.items.sumOf { it.price },
                (Random.nextInt(100000000 - 1000000000) + 100000000).toString(),
                OrderStatus.CREATED
            )
        )

    fun cancelOrder(orderId: String): Order? =
        repository.cancel(orderId)

    fun findById(orderId: String): Order? =
        repository.findById(orderId)
}