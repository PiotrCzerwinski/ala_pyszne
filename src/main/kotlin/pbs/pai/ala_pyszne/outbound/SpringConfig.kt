package pbs.pai.ala_pyszne.outbound

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import pbs.pai.ala_pyszne.core.require.OrderRepository
import pbs.pai.ala_pyszne.core.require.RestaurantRepository
import pbs.pai.ala_pyszne.core.usecase.OrderUseCase
import pbs.pai.ala_pyszne.core.usecase.RestaurantUseCase
import pbs.pai.ala_pyszne.outbound.mongo.*

@Configuration
class SpringConfig {

    @Bean
    fun orderRepository(repository: MongoEntityOrderRepository) : OrderRepository =
        MongoOrderRepository(repository)

    @Bean
    fun restaurantRepository(repository: MongoEntityRestaurantRepository) : RestaurantRepository =
        MongoRestaurantRepository(repository)

    @Bean
    fun restaurantUseCase(
        repository: RestaurantRepository
    ): RestaurantUseCase = RestaurantUseCase(repository)

    @Bean
    fun orderUseCase(
        repository: OrderRepository
    ): OrderUseCase = OrderUseCase(repository)

    @Bean
    fun dataInit(
        restaurantRepository: RestaurantRepository,
        orderRepository: OrderRepository
    ): DataInit = DataInit(restaurantRepository, orderRepository)
}