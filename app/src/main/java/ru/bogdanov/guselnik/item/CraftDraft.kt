package ru.bogdanov.guselnik.item

import android.view.View

data class CraftDraft(
    val recipeItem: RecipeItem,
    val xPos: Float,
    val yPos: Float,
    val needToanimateDown:Boolean
)