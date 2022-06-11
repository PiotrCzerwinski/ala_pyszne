package pbs.pai.ala_pyszne.outbound.mongo

import org.springframework.boot.CommandLineRunner
import pbs.pai.ala_pyszne.core.domain.Address
import pbs.pai.ala_pyszne.core.domain.Ingredient
import pbs.pai.ala_pyszne.core.domain.MenuItem
import pbs.pai.ala_pyszne.core.domain.Restaurant
import pbs.pai.ala_pyszne.core.require.OrderRepository
import pbs.pai.ala_pyszne.core.require.RestaurantRepository
import java.time.LocalTime
import java.util.UUID
import javax.annotation.PostConstruct

class DataInit(
    val restaurantRepository: RestaurantRepository,
    val orderRepository: OrderRepository
): CommandLineRunner {

    fun fillDatabase() {
        restaurantRepository.save(
            Restaurant(
                "pizza-i-gitara-id",
                "Pizza i gitara",
                "Najlepsza pizzeria w Bydgoszczy. Serio.",
                Address(
                    "Bydgoszcz",
                    "Stary port",
                    "9",
                    null
                ),
                LocalTime.of(11, 0),
                LocalTime.of(21, 30),
                listOf(
                    MenuItem(
                        "Margarita", 39.0, listOf(
                            Ingredient("Mozarella"),
                            Ingredient("Sos pomidorowy")
                        )
                    )
                )
            )
        )
    }

    override fun run(vararg args: String?) {
        fillDatabase()
    }
}