package pbs.pai.ala_pyszne

import com.fasterxml.jackson.databind.ObjectMapper
import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.hamcrest.Matchers
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.test.context.ActiveProfiles
import pbs.pai.ala_pyszne.core.domain.*
import pbs.pai.ala_pyszne.core.expose.CustomerData
import pbs.pai.ala_pyszne.core.expose.OrderData
import pbs.pai.ala_pyszne.core.require.MenuItemRepository
import pbs.pai.ala_pyszne.core.require.OrderRepository
import java.time.LocalTime
import java.util.*

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("embedmongo")
class OrderControllerTest {
    @Autowired
    private lateinit var orderRepository: OrderRepository

    @Autowired
    private lateinit var menuItemRepository: MenuItemRepository

    @Test
    fun ` should return status OK`() {
        val orderid = "order-id-1"

        val request = RestAssured
                .given()
                .contentType(ContentType.JSON)
        val response = request.get("/order/$orderid")
        val statusCode = response.statusCode
        assertEquals(statusCode, 200)
    }

    @Test
    fun ` should return order`() {
        val orderid = "order-id-1"
        val order = orderRepository.findById(orderid)
        val request = RestAssured
                .given()
                .contentType(ContentType.JSON)
        val response = request.get("/order/$orderid")
                .then()
                .extract()
                .response()

        val statusCode = response.statusCode
        assertEquals(orderid, response.jsonPath().getString("id"))
        assertEquals(statusCode, 200)
        assertEquals("CREATED", response.jsonPath().getString("orderStatus"))
    }
    /*
       @Test
     fun ` should create order`() {
   val customer = CustomerData("Karol", "Fac", "555-555-555", null)

           val orderData = OrderData(

                   "pizza-i-gitara-id",
                   customer,
                   Address("jarocin", "milo", "12", "23"),
                   mapOf("Margarita-id" to 1)
                   )
           val request = RestAssured
                   .given()
                   .contentType(ContentType.JSON)
                   .body(orderData)
           val response = request.post("/order")
                   .then()
                   .contentType(ContentType.JSON)
                   .statusCode(200)
                   .assertThat()
                   .body("customerData", Matchers.equalTo(customer))
                   }*/
}
