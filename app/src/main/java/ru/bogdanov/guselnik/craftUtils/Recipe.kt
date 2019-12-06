package ru.bogdanov.guselnik.craftUtils

import kotlin.math.max
import kotlin.math.min

class Recipe {
    val recipeMap= mutableMapOf<String, String>()
    val musicalRecipeMap= mutableMapOf<String, String>()

    init {
        fillRecipeMap()
        fillMusicalRecipeMap()
    }



    fun getNewViewType(droppedType: String, secondType: String): String {
        return recipeMap.get(getHash(droppedType, secondType))?:"none"
    }

    private fun fillMusicalRecipeMap() {
        addToMusicalRecipeMap("sliver","sliver", "crackle") //трещетка

        addToMusicalRecipeMap("plank","stick", "drum") //барабанка
        addToMusicalRecipeMap("plankHoled","stick", "drum")

        addToMusicalRecipeMap("log","stick", "firewood") //дрова

        addToMusicalRecipeMap("cane","cane", "kukigl") //кугиклы
        addToMusicalRecipeMap("tube","tube", "kukigl")
        addToMusicalRecipeMap("cane","axe", "kukigl")
        addToMusicalRecipeMap("tube","axe", "kukigl")

        addToMusicalRecipeMap("tube","chisel", "kaluka") //калюка
        addToMusicalRecipeMap("cane","chisel", "kaluka")

        addToMusicalRecipeMap("kaluka","chisel", "whistle") //свирель
        addToMusicalRecipeMap("tubeHoled","chisel", "whistle")

        addToMusicalRecipeMap("whistle","whistle", "whistleDouble") //свирель двойчатка
        addToMusicalRecipeMap("whistle","kaluka", "whistleDouble")

        addToMusicalRecipeMap("tubeHoled","knife", "pishik") //пищик
        addToMusicalRecipeMap("tubeHoled","tongue", "pishik")

        addToMusicalRecipeMap("pishik","pishik", "pishikDouble") //двойной пищик

        addToMusicalRecipeMap("pishik","bark", "kurskWhistle") //курский рожок

        addToMusicalRecipeMap("tubeHoled","bark", "nerehtWhistle") //нерехтский рожек
        addToMusicalRecipeMap("shepherdWhistle","chisel", "nerehtWhistle")

        addToMusicalRecipeMap("tube","bark", "shepherdWhistle") //постушеская труба
        addToMusicalRecipeMap("tube","tongue", "shepherdWhistle")
        addToMusicalRecipeMap("tongue","bark", "shepherdWhistle")

        addToMusicalRecipeMap("bark","bark", "sharkunok") //шаркунок

        addToMusicalRecipeMap("stick","axe", "rubel") //рубель

        addToMusicalRecipeMap("spoon","spoon", "spoons") //ложки

        addToMusicalRecipeMap("bodyWindow","peg", "gusliLir") //гусли лирообразные

        addToMusicalRecipeMap("body","neck", "balalayka") //балалайка
        addToMusicalRecipeMap("bodyHoled","neck", "balalayka")

        addToMusicalRecipeMap("gusliLir","bow", "gudok") //gudok
        addToMusicalRecipeMap("gusliKril","bow", "gudok")

        addToMusicalRecipeMap("balalayka","bow", "violin") //скрипка
        addToMusicalRecipeMap("gudok","neck", "violin")

        addToMusicalRecipeMap("gudok","wheel", "wheeledLyra") //колесная лира
        addToMusicalRecipeMap("gudok","wheelLyra", "wheeledLyra")

        addToMusicalRecipeMap("щепка","chisel", "greben") //гребень

        addToMusicalRecipeMap("gusliKril","stick", "cimbal") //цимбалы

        addToMusicalRecipeMap("body","peg", "gusliKril") //гусли крыловидные
        addToMusicalRecipeMap("bodyWindow","peg", "gusliKril")
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

    private fun addToMusicalRecipeMap(type1:String, type2:String, resultType:String){
        musicalRecipeMap.put(
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