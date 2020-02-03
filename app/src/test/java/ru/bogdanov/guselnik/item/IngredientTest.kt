package ru.bogdanov.guselnik.item

import org.junit.Assert.*
import org.junit.Test

class IngredientTest{
    @Test
    fun getInstrumentsWithSoundCount(){
        println(Ingredient.values().count { it.isInstrument })
    }
}