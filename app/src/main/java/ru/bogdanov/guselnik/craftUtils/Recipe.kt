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

        addToRecipeMap("log", "knife", "stick") //палка
        addToRecipeMap("stick", "peg", "neck") //гриф
//
        addToRecipeMap("stick", "chisel", "tube") //трубка

        addToRecipeMap("tube", "chisel", "tubeHoled") //трубка с отверстиями
        addToRecipeMap("cane", "chisel", "tubeHoled") //трубка с отверстиями

        addToRecipeMap("knife", "plank", "deck") //дека
        addToRecipeMap("deck", "chisel", "deckHoled") //дека с дырками
        addToRecipeMap("plankHoled", "knife", "deckHoled") //дека с дырками
        addToRecipeMap("plank", "chisel", "plankHoled") //доска с отверстиями


        /*
        колесо=доска с отверстием+топор
        колесо лиры=колесо+смола

        корытце=полено+долото

        корпус=корытце+дека

        корпус с отверстием=корытце+дека с отверстием
        корпус с отверстием=корпус+долото

        корпус с окном=корытце с окном+дека
        корпус с окном=корытце с окном+дека с отверстием
        корпус с окном=корпус+топор

        язычок=береста\кора+нож
        язычок=тростник+нож
        язычок=трубка+нож
        язычок=щепка+нож

        смола=береста\кора+топор
        смола=береста\кора+долото

        смык=палка+смола

        ложка=палка+нож
*/
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