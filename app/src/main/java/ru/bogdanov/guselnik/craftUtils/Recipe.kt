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

        addToRecipeMap("stick", "chisel", "tube") //трубка

        addToRecipeMap("tube", "chisel", "tubeHoled") //трубка с отверстиями
        addToRecipeMap("cane", "chisel", "tubeHoled") //трубка с отверстиями

        addToRecipeMap("knife", "plank", "deck") //дека
        addToRecipeMap("deck", "chisel", "deckHoled") //дека с дырками
        addToRecipeMap("plankHoled", "knife", "deckHoled") //дека с дырками
        addToRecipeMap("plank", "chisel", "plankHoled") //доска с отверстиями

        addToRecipeMap("plankHoled", "axe", "wheel") //колесо
        addToRecipeMap("wheel", "resin", "wheelLyra") //колесо для лиры

        addToRecipeMap("chisel", "log", "trough") //корыто
        addToRecipeMap("trough", "axe", "troughWindow") //корыто с окном
        addToRecipeMap("trough", "deck", "body") //корпус

        addToRecipeMap("trough", "deckHoled", "bodyHoled") //корпус с отверстиями
        addToRecipeMap("body", "chisel", "bodyHoled") //корпус с отверстиями

        addToRecipeMap("troughWindow", "deck", "bodyWindow") //корпус с окном
        addToRecipeMap("troughWindow", "deckHoled", "bodyWindow") //корпус с окном
        addToRecipeMap("body", "axe", "bodyWindow") //корпус с окном

        addToRecipeMap("bark", "knife", "tongue") //язычок
        addToRecipeMap("cane", "knife", "tongue") //язычок
        addToRecipeMap("tube", "knife", "tongue") //язычок
        addToRecipeMap("sliver", "knife", "tongue") //язычок

        addToRecipeMap("bark", "axe", "resin") //смола
        addToRecipeMap("bark", "chisel", "resin") //смола

        addToRecipeMap("stick", "resin", "bow") //смык

        addToRecipeMap("stick", "knife", "spoon") //ложка
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