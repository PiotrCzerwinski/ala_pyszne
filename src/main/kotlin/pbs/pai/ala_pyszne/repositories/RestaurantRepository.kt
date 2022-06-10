package pbs.pai.ala_pyszne.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import pbs.pai.ala_pyszne.core.domain.Restaurant

@Repository
interface RestaurantRepository : MongoRepository<Restaurant, Long> {
}