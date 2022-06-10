package pbs.pai.ala_pyszne.outbound.mongo

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import pbs.pai.ala_pyszne.core.domain.require.OrderRepository
import pbs.pai.ala_pyszne.core.domain.require.RestaurantRepository

@Configuration
class SpringConfig {

    @Bean
    fun orderRepository(repository: MongoEntityOrderRepository) : OrderRepository =
        MongoOrderRepository(repository)

    @Bean
    fun restaurantRepository(repository: MongoEntityRestaurantRepository) : RestaurantRepository =
        MongoRestaurantRepository(repository)
}