package ru.bogdanov.guselnik.craftUtils

import android.view.View
import ru.bogdanov.guselnik.custom.CreatedCraftView
import ru.bogdanov.guselnik.item.AnimVector
import ru.bogdanov.guselnik.item.CraftDraft
import ru.bogdanov.guselnik.item.CraftItem
import ru.bogdanov.guselnik.item.Ingredient
import ru.bogdanov.guselnik.item.Ingredient.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CraftItemCombiner @Inject constructor (val recipe: Recipe) {
    fun combine(
        dropped: View,
        catcher: View,
        function: (draft: CraftDraft?, arrayToDelete: Array<View>?) -> Unit
    ) {
        val droppedType = (dropped as CraftItem).type
        val catchType = (catcher as CraftItem).type

        val newIngredient = recipe.getNewIngredient(droppedType, catchType)

        if (newIngredient != null) {
            val draft = getDraft(newIngredient, catchType, dropped, catcher)
            val arrayToDelete = tryToDelete(dropped, catcher, catchType)
            function(draft, arrayToDelete)
        } else
            function(null, tryBurnInBonFire(dropped, catchType))
    }

    private fun tryToDelete(dropped: View, catcher: View, catchType: String): Array<View>? {
        if (catcher is CreatedCraftView && isWorkTool(dropped)) return arrayOf(catcher)

        if (catchType == BONFIRE.type || catchType == FOREST.type)
            if (!isWorkTool(dropped))
            return arrayOf(dropped)

        if (dropped is CreatedCraftView && catcher is CreatedCraftView) return arrayOf(
            dropped,
            catcher
        )
        return null
    }

    private fun isWorkTool(view: View): Boolean {
        val type=(view as CraftItem).type
        return type == AXE.type || type == CHISEL.type || type == KNIFE.type
    }

    private fun getDraft(
        ingredient: Ingredient,
        catchType: String,
        dropped: View,
        catcher: View
    ): CraftDraft {

        val coordinates = getCoordinates(dropped, catcher)

        return CraftDraft(
            ingredient,
            coordinates.first,
            coordinates.second,
            when (catchType){
                FOREST.type->AnimVector.FOREST
                BONFIRE.type->AnimVector.BONFIRE
                else->AnimVector.NONE
            }
        )
    }

    private fun getCoordinates(
        dropped: View,
        catcher: View
    ): Pair<Float, Float> {
        if ((catcher as CraftItem).type == FOREST.type) return dropped.getCenter()
        else {
            val coord1 = dropped.getCenter()
            val coord2 = catcher.getCenter()

            return Pair(
                (coord1.first + coord2.first) / 2,
                (coord1.second + coord2.second) / 2
            )
        }
    }

    private fun tryBurnInBonFire(dropped: View, catchType: String): Array<View>? {
        if (catchType == BONFIRE.type) return arrayOf(dropped)
        return null
    }
}


