package pbs.pai.ala_pyszne.outbound.mongo

import org.springframework.data.repository.findByIdOrNull
import pbs.pai.ala_pyszne.core.domain.Order
import pbs.pai.ala_pyszne.core.domain.require.OrderRepository

class MongoOrderRepository(private val repository: MongoEntityOrderRepository) : OrderRepository {
    override fun findById(id: String): Order? =
        repository.findByIdOrNull(id)

    override fun save(order: Order): Order =
        repository.save(order)

    override fun cancel(id: String) {
        repository.deleteById(id)
    }
}