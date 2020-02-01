package ru.bogdanov.guselnik.interfaces

import android.view.View
import ru.bogdanov.guselnik.item.CraftDraft
import ru.bogdanov.guselnik.item.Ingredient

interface CraftListener {
    fun createView(draft:CraftDraft)
    fun removeView(view:View)
    fun newInstrumentOpened(ingredient: Ingredient)
}