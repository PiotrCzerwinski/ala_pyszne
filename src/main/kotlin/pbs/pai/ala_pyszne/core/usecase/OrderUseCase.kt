package pbs.pai.ala_pyszne.core.usecase

import pbs.pai.ala_pyszne.core.domain.Customer
import pbs.pai.ala_pyszne.core.domain.MenuItem
import pbs.pai.ala_pyszne.core.domain.Order
import pbs.pai.ala_pyszne.core.domain.OrderStatus
import pbs.pai.ala_pyszne.core.expose.OrderData
import pbs.pai.ala_pyszne.core.require.MenuItemRepository
import pbs.pai.ala_pyszne.core.require.OrderRepository
import java.time.LocalDateTime
import java.util.*

class OrderUseCase(
    private val orderRepository: OrderRepository,
    private val menuItemRepository: MenuItemRepository
) {
    fun createOrder(orderData: OrderData): Order? {
        val menuItems = menuItemRepository.findByIds(orderData.menuItemIdAndAmount.keys)

        if(menuItems.isNotEmpty()) {
            return orderRepository.save(
                Order(
                    UUID.randomUUID().toString(),
                    Customer(
                        UUID.randomUUID().toString(),
                        orderData.customerData.name,
                        orderData.customerData.surname,
                        orderData.customerData.phoneNumber,
                        orderData.customerData.email,
                    ),
                    orderData.restaurantId,
                    LocalDateTime.now(),
                    orderData.destination,
                    menuItems,
                    calculateTotal(orderData.menuItemIdAndAmount,menuItems),
                    "654765234",
                    OrderStatus.CREATED
                )
            )
        }
        return null
    }

    fun cancelOrder(orderId: String): Order? =
        orderRepository.cancel(orderId)

    fun findById(orderId: String): Order? =
        orderRepository.findById(orderId)

    fun nextStatus(orderId: String): OrderStatus?{
        val order = orderRepository.findById(orderId)
        return if(order == null) null
        else {
            val currentIndex = OrderStatus.values().indexOf(order.orderStatus)
            if(currentIndex < OrderStatus.values().size -1)
                orderRepository.save(order.copy(
                    orderStatus = OrderStatus.values()[currentIndex+1]
                )).orderStatus
            else order.orderStatus
        }
    }

    fun getStatus(orderId: String): OrderStatus? {
        return orderRepository.findById(orderId)?.orderStatus
    }

    private fun calculateTotal(order: Map<String,Int>, items: List<MenuItem>):Double =
        items.sumOf {
            it.price * order[it.id]!!
        }
}