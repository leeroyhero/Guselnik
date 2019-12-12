package ru.bogdanov.guselnik.craftUtils

import ru.bogdanov.guselnik.item.Ingredient
import kotlin.math.max
import kotlin.math.min

class Recipe {
    val recipeMap = mutableMapOf<String, Ingredient>()

    init {
        fillRecipeMap()
        fillMusicalRecipeMap()
    }

    fun getNewIngredient(droppedType: String, secondType: String): Ingredient? {
        return recipeMap.get(getHash(droppedType, secondType))
    }

    private fun fillMusicalRecipeMap() {
        addToRecipeMap(Ingredient.SPOON.type, Ingredient.SPOON.type, Ingredient.SPOONS) //ложки
    }

    private fun fillRecipeMap() {
        addToRecipeMap(AXE, FOREST, Ingredient.POLENO) //полено
        addToRecipeMap(KNIFE, FOREST, Ingredient.TROSTNIK) //тростник
        addToRecipeMap(CHISEL, FOREST, Ingredient.KORA) //кора

        addToRecipeMap(Ingredient.POLENO.type, KNIFE, Ingredient.PALKA) //палка

        addToRecipeMap(Ingredient.PALKA.type, CHISEL, Ingredient.SPOON) //палка
        addToRecipeMap(Ingredient.POLENO.type, BONFIRE, Ingredient.UGOL)
    }

    private fun addToRecipeMap(type1: String, type2: String, result: Ingredient) {
        recipeMap.put(
            getHash(type1, type2),
            result
        )
    }

    private fun getHash(type1: String, type2: String): String {
        val hash1 = type1.hashCode()
        val hash2 = type2.hashCode()
        return "${max(hash1, hash2)}${min(hash1, hash2)}"
    }
}