package pbs.pai.ala_pyszne.core.require

import pbs.pai.ala_pyszne.core.domain.Order

interface OrderRepository {
    fun findById(id: String): Order?
    fun save(order: Order): Order
    fun cancel(id: String): Order?
}