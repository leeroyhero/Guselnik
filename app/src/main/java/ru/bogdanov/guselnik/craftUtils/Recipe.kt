package ru.bogdanov.guselnik.craftUtils

import ru.bogdanov.guselnik.item.Ingredient
import ru.bogdanov.guselnik.item.Instrument
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
        addToRecipeMap("sliver","sliver", Instrument.Crackle()) //трещетка

        addToRecipeMap("plank","stick", Instrument.Drum()) //барабанка
        addToRecipeMap("plankHoled","stick", Instrument.Drum())

        addToRecipeMap("log","stick", Instrument.Firewood()) //дрова

        addToRecipeMap("cane","cane", Instrument.Kukigl()) //кугиклы
        addToRecipeMap("tube","tube", Instrument.Kukigl())
        addToRecipeMap("cane","axe", Instrument.Kukigl())
        addToRecipeMap("tube","axe", Instrument.Kukigl())

        addToRecipeMap("tube","chisel", Instrument.Kaluka()) //калюка
        addToRecipeMap("cane","chisel", Instrument.Kaluka())

        addToRecipeMap("kaluka","chisel", Instrument.Whistle()) //свирель
        addToRecipeMap("tubeHoled","chisel", Instrument.Whistle())

        addToRecipeMap("whistle","whistle", Instrument.WhistleDouble()) //свирель двойчатка
        addToRecipeMap("whistle","kaluka", Instrument.WhistleDouble())

        addToRecipeMap("tubeHoled","knife", Instrument.Pishik()) //пищик
        addToRecipeMap("tubeHoled","tongue", Instrument.Pishik())

        addToRecipeMap("pishik","pishik", Instrument.PishikDouble()) //двойной пищик

        addToRecipeMap("pishik","bark", Instrument.KurskWhistle()) //курский рожок

        addToRecipeMap("tubeHoled","bark", Instrument.NerehtWhistle()) //нерехтский рожек
        addToRecipeMap("shepherdWhistle","chisel", Instrument.NerehtWhistle())

        addToRecipeMap("tube","bark", Instrument.ShepherdWhistle()) //постушеская труба
        addToRecipeMap("tube","tongue", Instrument.ShepherdWhistle())
        addToRecipeMap("tongue","bark", Instrument.ShepherdWhistle())

        addToRecipeMap("bark","bark", Instrument.Sharkunok()) //шаркунок

        addToRecipeMap("stick","axe", Instrument.Rubel()) //рубель

        addToRecipeMap("spoon","spoon", Instrument.Spoons()) //ложки

        addToRecipeMap("bodyWindow","peg", Instrument.GusliLir()) //гусли лирообразные

        addToRecipeMap("body","neck", Instrument.Balalayka()) //балалайка
        addToRecipeMap("bodyHoled","neck", Instrument.Balalayka())

        addToRecipeMap("gusliLir","bow", Instrument.Gudok()) //gudok
        addToRecipeMap("gusliKril","bow", Instrument.Gudok())

        addToRecipeMap("balalayka","bow", Instrument.Violin()) //скрипка
        addToRecipeMap("gudok","neck", Instrument.Violin())

        addToRecipeMap("gudok","wheel", Instrument.WheeledLyra()) //колесная лира
        addToRecipeMap("gudok","wheelLyra", Instrument.WheeledLyra())

        addToRecipeMap("щепка","chisel", Instrument.Greben()) //гребень

        addToRecipeMap("gusliKril","stick", Instrument.Cimbal()) //цимбалы

        addToRecipeMap("body","peg", Instrument.GusliKril()) //гусли крыловидные
        addToRecipeMap("bodyHoled","peg", Instrument.GusliKril())
    }

    private fun fillRecipeMap() {
        addToRecipeMap("axe", "forest", Ingredient.Log()) //полено
        addToRecipeMap("knife", "forest", Ingredient.Cane()) //тростник
        addToRecipeMap("chisel", "forest", Ingredient.Bark()) //кора

        addToRecipeMap("axe", "log", Ingredient.Plank()) //доска

        addToRecipeMap("axe", "plank", Ingredient.Sliver()) //щепка
        addToRecipeMap("axe", "sliver", Ingredient.Peg()) //колок

        addToRecipeMap("log", "knife", Ingredient.Stick()) //палка
        addToRecipeMap("stick", "peg", Ingredient.Neck()) //гриф

        addToRecipeMap("stick", "chisel", Ingredient.Tube()) //трубка

        addToRecipeMap("tube", "chisel", Ingredient.TubeHoled()) //трубка с отверстиями
        addToRecipeMap("cane", "chisel", Ingredient.TubeHoled()) //трубка с отверстиями

        addToRecipeMap("knife", "plank", Ingredient.Deck()) //дека
        addToRecipeMap("deck", "chisel", Ingredient.DeckHoled()) //дека с дырками
        addToRecipeMap("plankHoled", "knife", Ingredient.DeckHoled()) //дека с дырками
        addToRecipeMap("plank", "chisel", Ingredient.PlankHoled()) //доска с отверстиями

        addToRecipeMap("plankHoled", "axe", Ingredient.Wheel()) //колесо
        addToRecipeMap("wheel", "resin", Ingredient.WheelLyra()) //колесо для лиры

        addToRecipeMap("chisel", "log", Ingredient.Trough()) //корыто
        addToRecipeMap("trough", "axe", Ingredient.TroughWindow()) //корыто с окном
        addToRecipeMap("trough", "deck", Ingredient.Body()) //корпус

        addToRecipeMap("trough", "deckHoled", Ingredient.BodyHoled()) //корпус с отверстиями
        addToRecipeMap("body", "chisel", Ingredient.BodyHoled()) //корпус с отверстиями

        addToRecipeMap("troughWindow", "deck", Ingredient.BodyWindow()) //корпус с окном
        addToRecipeMap("troughWindow", "deckHoled", Ingredient.BodyWindow()) //корпус с окном
        addToRecipeMap("body", "axe", Ingredient.BodyWindow()) //корпус с окном

        addToRecipeMap("bark", "knife", Ingredient.Tongue()) //язычок
        addToRecipeMap("cane", "knife", Ingredient.Tongue()) //язычок
        addToRecipeMap("tube", "knife", Ingredient.Tongue()) //язычок
        addToRecipeMap("sliver", "knife", Ingredient.Tongue()) //язычок

        addToRecipeMap("bark", "axe", Ingredient.Resin()) //смола
        addToRecipeMap("bark", "chisel", Ingredient.Resin()) //смола

        addToRecipeMap("stick", "resin", Ingredient.Bow()) //смык

        addToRecipeMap("stick", "knife", Ingredient.Spoon()) //ложка
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