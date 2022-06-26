package pbs.pai.ala_pyszne.web

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import pbs.pai.ala_pyszne.core.usecase.RestaurantUseCase

@Controller
class RestaurantWebController(
        private val restaurantUseCase: RestaurantUseCase
){

    @RequestMapping("")
    @ResponseStatus(HttpStatus.OK)
    fun mainPage(model: Model) : String{
        model.addAttribute("restaurant", restaurantUseCase.getAll()[0])
        return "restaurant"
    }

    @RequestMapping("/menu")
    @ResponseStatus(HttpStatus.OK)
    fun menuPage(model: Model) : String{
        model.addAttribute("restaurant", restaurantUseCase.getAll()[0])
        return "menu"
    }

    @RequestMapping("/kontakt")
    @ResponseStatus(HttpStatus.OK)
    fun contactPage(model: Model) : String{
        model.addAttribute("restaurant", restaurantUseCase.getAll()[0])
        return "contact"
    }

}