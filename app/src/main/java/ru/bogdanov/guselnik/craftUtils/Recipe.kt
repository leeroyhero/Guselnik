package ru.bogdanov.guselnik.craftUtils

import ru.bogdanov.guselnik.item.Ingredients
import ru.bogdanov.guselnik.item.Instruments
import ru.bogdanov.guselnik.item.RecipeItem
import kotlin.math.max
import kotlin.math.min

class Recipe {
    val recipeMap= mutableMapOf<String, RecipeItem>()

    init {
        fillRecipeMap()
        fillMusicalRecipeMap()
    }

    fun getNewViewType(droppedType: String, secondType: String): RecipeItem? {
        return recipeMap.get(getHash(droppedType, secondType))
    }

    private fun fillMusicalRecipeMap() {
        addToRecipeMap("sliver","sliver", Instruments.Crackle()) //трещетка

        addToRecipeMap("plank","stick", Instruments.Drum()) //барабанка
        addToRecipeMap("plankHoled","stick", Instruments.Drum())

        addToRecipeMap("log","stick", Instruments.Firewood()) //дрова

        addToRecipeMap("cane","cane", Instruments.Kukigl()) //кугиклы
        addToRecipeMap("tube","tube", Instruments.Kukigl())
        addToRecipeMap("cane","axe", Instruments.Kukigl())
        addToRecipeMap("tube","axe", Instruments.Kukigl())

        addToRecipeMap("tube","chisel", Instruments.Kaluka()) //калюка
        addToRecipeMap("cane","chisel", Instruments.Kaluka())

        addToRecipeMap("kaluka","chisel", Instruments.Whistle()) //свирель
        addToRecipeMap("tubeHoled","chisel", Instruments.Whistle())

        addToRecipeMap("whistle","whistle", Instruments.WhistleDouble()) //свирель двойчатка
        addToRecipeMap("whistle","kaluka", Instruments.WhistleDouble())

        addToRecipeMap("tubeHoled","knife", Instruments.Pishik()) //пищик
        addToRecipeMap("tubeHoled","tongue", Instruments.Pishik())

        addToRecipeMap("pishik","pishik", Instruments.PishikDouble()) //двойной пищик

        addToRecipeMap("pishik","bark", Instruments.KurskWhistle()) //курский рожок

        addToRecipeMap("tubeHoled","bark", Instruments.NerehtWhistle()) //нерехтский рожек
        addToRecipeMap("shepherdWhistle","chisel", Instruments.NerehtWhistle())

        addToRecipeMap("tube","bark", Instruments.ShepherdWhistle()) //постушеская труба
        addToRecipeMap("tube","tongue", Instruments.ShepherdWhistle())
        addToRecipeMap("tongue","bark", Instruments.ShepherdWhistle())

        addToRecipeMap("bark","bark", Instruments.Sharkunok()) //шаркунок

        addToRecipeMap("stick","axe", Instruments.Rubel()) //рубель

        addToRecipeMap("spoon","spoon", Instruments.Spoons()) //ложки

        addToRecipeMap("bodyWindow","peg", Instruments.GusliLir()) //гусли лирообразные

        addToRecipeMap("body","neck", Instruments.Balalayka()) //балалайка
        addToRecipeMap("bodyHoled","neck", Instruments.Balalayka())

        addToRecipeMap("gusliLir","bow", Instruments.Gudok()) //gudok
        addToRecipeMap("gusliKril","bow", Instruments.Gudok())

        addToRecipeMap("balalayka","bow", Instruments.Violin()) //скрипка
        addToRecipeMap("gudok","neck", Instruments.Violin())

        addToRecipeMap("gudok","wheel", Instruments.WheeledLyra()) //колесная лира
        addToRecipeMap("gudok","wheelLyra", Instruments.WheeledLyra())

        addToRecipeMap("щепка","chisel", Instruments.Greben()) //гребень

        addToRecipeMap("gusliKril","stick", Instruments.Cimbal()) //цимбалы

        addToRecipeMap("body","peg", Instruments.GusliKril()) //гусли крыловидные
        addToRecipeMap("bodyHoled","peg", Instruments.GusliKril())
    }

    private fun fillRecipeMap() {
        addToRecipeMap("axe", "forest", Ingredients.Log()) //полено
        addToRecipeMap("knife", "forest", Ingredients.Cane()) //тростник
        addToRecipeMap("chisel", "forest", Ingredients.Bark()) //кора

        addToRecipeMap("axe", "log", Ingredients.Plank()) //доска

        addToRecipeMap("axe", "plank", Ingredients.Sliver()) //щепка
        addToRecipeMap("axe", "sliver", Ingredients.Peg()) //колок

        addToRecipeMap("log", "knife", Ingredients.Stick()) //палка
        addToRecipeMap("stick", "peg", Ingredients.Neck()) //гриф

        addToRecipeMap("stick", "chisel", Ingredients.Tube()) //трубка

        addToRecipeMap("tube", "chisel", Ingredients.TubeHoled()) //трубка с отверстиями
        addToRecipeMap("cane", "chisel", Ingredients.TubeHoled()) //трубка с отверстиями

        addToRecipeMap("knife", "plank", Ingredients.Deck()) //дека
        addToRecipeMap("deck", "chisel", Ingredients.DeckHoled()) //дека с дырками
        addToRecipeMap("plankHoled", "knife", Ingredients.DeckHoled()) //дека с дырками
        addToRecipeMap("plank", "chisel", Ingredients.PlankHoled()) //доска с отверстиями

        addToRecipeMap("plankHoled", "axe", Ingredients.Wheel()) //колесо
        addToRecipeMap("wheel", "resin", Ingredients.WheelLyra()) //колесо для лиры

        addToRecipeMap("chisel", "log", Ingredients.Trough()) //корыто
        addToRecipeMap("trough", "axe", Ingredients.TroughWindow()) //корыто с окном
        addToRecipeMap("trough", "deck", Ingredients.Body()) //корпус

        addToRecipeMap("trough", "deckHoled", Ingredients.BodyHoled()) //корпус с отверстиями
        addToRecipeMap("body", "chisel", Ingredients.BodyHoled()) //корпус с отверстиями

        addToRecipeMap("troughWindow", "deck", Ingredients.BodyWindow()) //корпус с окном
        addToRecipeMap("troughWindow", "deckHoled", Ingredients.BodyWindow()) //корпус с окном
        addToRecipeMap("body", "axe", Ingredients.BodyWindow()) //корпус с окном

        addToRecipeMap("bark", "knife", Ingredients.Tongue()) //язычок
        addToRecipeMap("cane", "knife", Ingredients.Tongue()) //язычок
        addToRecipeMap("tube", "knife", Ingredients.Tongue()) //язычок
        addToRecipeMap("sliver", "knife", Ingredients.Tongue()) //язычок

        addToRecipeMap("bark", "axe", Ingredients.Resin()) //смола
        addToRecipeMap("bark", "chisel", Ingredients.Resin()) //смола

        addToRecipeMap("stick", "resin", Ingredients.Bow()) //смык

        addToRecipeMap("stick", "knife", Ingredients.Spoon()) //ложка
    }

    private fun addToRecipeMap(type1:String, type2:String, result:RecipeItem){
        recipeMap.put(
            getHash(type1, type2),
            result
        )
    }

    private fun getHash(type1: String, type2: String): String {
        val hash1=type1.hashCode()
        val hash2=type2.hashCode()
        return "${max(hash1, hash2)}${min(hash1,hash2)}"
    }
}