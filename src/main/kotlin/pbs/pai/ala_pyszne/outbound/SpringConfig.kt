package pbs.pai.ala_pyszne.outbound

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import pbs.pai.ala_pyszne.core.require.OrderRepository
import pbs.pai.ala_pyszne.core.require.RestaurantRepository
import pbs.pai.ala_pyszne.outbound.mongo.MongoEntityOrderRepository
import pbs.pai.ala_pyszne.outbound.mongo.MongoEntityRestaurantRepository
import pbs.pai.ala_pyszne.outbound.mongo.MongoOrderRepository
import pbs.pai.ala_pyszne.outbound.mongo.MongoRestaurantRepository

@Configuration
class SpringConfig {

    @Bean
    fun orderRepository(repository: MongoEntityOrderRepository) : OrderRepository =
        MongoOrderRepository(repository)

    @Bean
    fun restaurantRepository(repository: MongoEntityRestaurantRepository) : RestaurantRepository =
        MongoRestaurantRepository(repository)
}