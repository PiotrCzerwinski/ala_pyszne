package pbs.pai.ala_pyszne.core.domain.require

import pbs.pai.ala_pyszne.core.domain.MenuItem
import pbs.pai.ala_pyszne.core.domain.Restaurant

interface RestaurantRepository {

    fun save(restaurant: Restaurant): Restaurant

    fun update(restaurant: Restaurant): Restaurant

}