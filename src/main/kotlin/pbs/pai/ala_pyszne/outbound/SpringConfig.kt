package pbs.pai.ala_pyszne.outbound

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import pbs.pai.ala_pyszne.core.require.MenuItemRepository
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
    fun menuItemRepository(repository: MongoEntityMenuItemRepository): MenuItemRepository =
        MongoMenuItemRepository(repository)

    @Bean
    fun restaurantUseCase(
        restaurantRepository: RestaurantRepository,
        menuItemRepository: MenuItemRepository
    ): RestaurantUseCase = RestaurantUseCase(restaurantRepository, menuItemRepository)

    @Bean
    fun orderUseCase(
        orderRepository: OrderRepository,
        menuItemRepository: MenuItemRepository
    ): OrderUseCase = OrderUseCase(orderRepository, menuItemRepository)

    @Bean
    fun dataInit(
        restaurantRepository: RestaurantRepository,
        orderRepository: OrderRepository
    ): DataInit = DataInit(restaurantRepository, orderRepository)
}