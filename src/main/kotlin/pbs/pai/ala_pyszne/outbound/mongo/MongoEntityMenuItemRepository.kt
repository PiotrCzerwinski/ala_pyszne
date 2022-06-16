package pbs.pai.ala_pyszne.outbound.mongo

import org.springframework.data.mongodb.repository.MongoRepository
import pbs.pai.ala_pyszne.core.domain.MenuItem

interface MongoEntityMenuItemRepository: MongoRepository<MenuItem, String> {

    fun findByIdIn(ids: Set<String>): List<MenuItem>
}