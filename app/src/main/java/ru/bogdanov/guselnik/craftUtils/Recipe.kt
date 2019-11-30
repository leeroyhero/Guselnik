package ru.bogdanov.guselnik.craftUtils

import kotlin.math.max
import kotlin.math.min

class Recipe {
    val recipeMap= mutableMapOf<String, String>()

    init {
        fillRecipeMap()
    }

    fun getNewViewType(droppedType: String, secondType: String): String {
        return recipeMap.get(getHash(droppedType, secondType))?:"none"
    }

    private fun fillRecipeMap() {
        addToRecipeMap("axe", "forest", "log") //полено
        addToRecipeMap("knife", "forest", "cane") //тростник
        addToRecipeMap("chisel", "forest", "bark") //кора

        addToRecipeMap("axe", "log", "plank") //доска
        addToRecipeMap("axe", "plank", "sliver") //щепка
        addToRecipeMap("axe", "sliver", "peg") //колок
    }

    private fun addToRecipeMap(type1:String, type2:String, resultType:String){
        recipeMap.put(
            getHash(type1, type2),
            resultType
        )
    }

    private fun getHash(type1: String, type2: String): String {
        val hash1=type1.hashCode()
        val hash2=type2.hashCode()
        return "${max(hash1, hash2)}${min(hash1,hash2)}"
    }
}