package ru.bogdanov.guselnik.craftUtils

import android.content.Context
import android.view.View
import kotlinx.android.synthetic.main.created_craft_view.view.*
import ru.bogdanov.guselnik.custom.FieldObject
import ru.bogdanov.guselnik.custom.CreatedCraftView
import ru.bogdanov.guselnik.item.Ingredient
import ru.bogdanov.guselnik.item.Instrument
import ru.bogdanov.guselnik.item.RecipeItem

class CraftViewFactory {
    fun getView(recipeItem: RecipeItem, context: Context?): View? {
        if (context == null) return null

        return when (recipeItem) {
            is Ingredient -> getIngredientsView(recipeItem, context)
            is Instrument -> getInstrumentView(recipeItem, context)
            else -> null
        }
    }

    private fun getInstrumentView(item: Instrument, context: Context): CreatedCraftView {
        val view = CreatedCraftView(context)
        (view as FieldObject).type = item.tag
        view.textViewName.text = item.name

        return view
    }

    private fun getIngredientsView(item: Ingredient, context: Context): CreatedCraftView {
        val view = CreatedCraftView(context)
        (view as FieldObject).type = item.tag
        view.textViewName.text = item.name

        return view
    }
}