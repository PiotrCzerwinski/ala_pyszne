package pbs.pai.ala_pyszne.inbound.rest

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import pbs.pai.ala_pyszne.core.domain.Order
import pbs.pai.ala_pyszne.core.domain.Restaurant
import pbs.pai.ala_pyszne.core.expose.OrderData
import pbs.pai.ala_pyszne.core.expose.RestaurantData
import pbs.pai.ala_pyszne.core.usecase.OrderUseCase

@RestController
class OrderController(
    val orderUseCase: OrderUseCase
) {

    @PostMapping("/order")
    fun createOrder(@RequestBody orderData: OrderData): ResponseEntity<Order> =
       ResponseEntity(orderUseCase.createOrder(orderData), HttpStatus.OK)

    @GetMapping("/order/{id}")
    fun findById(@PathVariable id: String): ResponseEntity<Order> {
        val order = orderUseCase.findById(id)
        return  if(order != null) ResponseEntity(order,HttpStatus.OK) else ResponseEntity(HttpStatus.NOT_FOUND)
    }

    @PostMapping("order/cancel/{id}")
    fun cancedOrder(@PathVariable id: String): ResponseEntity<Order>{
        val order = orderUseCase.cancelOrder(id)
        return  if(order != null) ResponseEntity(order,HttpStatus.OK) else ResponseEntity(HttpStatus.OK)
    }

}