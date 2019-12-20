package ru.bogdanov.guselnik.item

import android.view.View

data class CraftDraft(
    val ingredient: Ingredient,
    val xPos: Float,
    val yPos: Float,
    val animVector: AnimVector
)