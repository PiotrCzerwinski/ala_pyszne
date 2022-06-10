package pbs.pai.ala_pyszne.repositories

import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import pbs.pai.ala_pyszne.core.domain.Ingredient

@Repository
interface IngredientRepository : MongoRepository<Ingredient?, Long?>{
}