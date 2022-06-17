package pbs.pai.ala_pyszne.outbound.mongo

import org.springframework.boot.CommandLineRunner
import pbs.pai.ala_pyszne.core.domain.*
import pbs.pai.ala_pyszne.core.require.OrderRepository
import pbs.pai.ala_pyszne.core.require.RestaurantRepository
import java.time.LocalDateTime
import java.time.LocalTime
import java.util.UUID
import javax.annotation.PostConstruct

class DataInit(
    val restaurantRepository: RestaurantRepository,
    val orderRepository: OrderRepository
) : CommandLineRunner {

    fun fillDatabase() {
        val pizzaIGitara = Restaurant(
            "pizza-i-gitara-id",
            "Pizza i gitara",
            "Najlepsza pizzeria w Bydgoszczy. Serio.",
            Address(
                "Bydgoszcz",
                "Stary port",
                "9",
            ),
            LocalTime.of(11, 0),
            LocalTime.of(21, 30),
            listOf(
                MenuItem(
                    "Margarita-id",
                    "Margarita",
                    39.0,
                    listOf(
                        Ingredient("Mozarella"),
                        Ingredient("Sos pomidorowy")
                    )
                )
            ))

            restaurantRepository.save(pizzaIGitara)

            orderRepository.save(
                Order(
                "order-id-1",
                    Customer(
                        UUID.randomUUID().toString(),
                        "Piotr",
                        "Czerwiński",
                        "567891234",
                        "czerwinski@gmail.com"
                    ),
                    pizzaIGitara.id,
                    LocalDateTime.now(),
                    Address(
                        "Bydgoszcz",
                        "Sniadeckich",
                        "13",
                    ),
                    listOf(pizzaIGitara.menuItems.first()),
                    pizzaIGitara.menuItems.first().price,
                    "789567345",
                    OrderStatus.CREATED
            )
            )
    }

    override fun run(vararg args: String?) {
        fillDatabase()
    }
}