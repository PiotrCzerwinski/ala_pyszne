package pbs.pai.ala_pyszne.outbound.mongo

import org.springframework.data.mongodb.repository.MongoRepository
import pbs.pai.ala_pyszne.core.domain.Order

interface MongoEntityOrderRepository : MongoRepository<Order,String> {
}