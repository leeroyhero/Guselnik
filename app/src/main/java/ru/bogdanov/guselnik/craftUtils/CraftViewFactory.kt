package ru.bogdanov.guselnik.craftUtils

import android.content.Context
import android.view.View
import kotlinx.android.synthetic.main.created_craft_view.view.*
import ru.bogdanov.guselnik.custom.FieldObject
import ru.bogdanov.guselnik.custom.CreatedCraftView
import ru.bogdanov.guselnik.item.CraftItem
import ru.bogdanov.guselnik.item.Ingredient

class CraftViewFactory {
    fun getView(ingredient: Ingredient, context: Context?): View? {
        if (context == null) return null

        return when (ingredient.isInstrument) {
            false -> getIngredientsView(ingredient, context)
            true -> getInstrumentView(ingredient, context)
        }
    }

    private fun getInstrumentView(item: Ingredient, context: Context): CreatedCraftView {
        val view = CreatedCraftView(context)
        (view as CraftItem).type = item.type
        view.textViewName.text = item.label

        return view
    }

    private fun getIngredientsView(item: Ingredient, context: Context): CreatedCraftView {
        val view = CreatedCraftView(context)
        (view as CraftItem).type = item.type
        view.textViewName.text = item.label
        return view
    }
}