package ru.bogdanov.guselnik.craftUtils

import android.content.Context
import android.view.View
import kotlinx.android.synthetic.main.created_craft_view.view.*
import ru.bogdanov.guselnik.custom.CraftView
import ru.bogdanov.guselnik.custom.CreatedCraftView
import ru.bogdanov.guselnik.item.Ingredients
import ru.bogdanov.guselnik.item.Instruments
import ru.bogdanov.guselnik.item.RecipeItem

class CraftViewFactory {
    fun getView(recipeItem: RecipeItem, context: Context?): View? {
        if (context == null) return null

        return when (recipeItem) {
            is Ingredients -> getIngredientsView(recipeItem, context)
            is Instruments -> getInstrumentView(recipeItem, context)
            else -> null
        }
    }

    private fun getInstrumentView(item: Instruments, context: Context): CreatedCraftView {
        val view = CreatedCraftView(context)
        (view as CraftView).type = item.tag
        view.textViewName.text = item.name

        return view
    }

    private fun getIngredientsView(item: Ingredients, context: Context): CreatedCraftView {
        val view = CreatedCraftView(context)
        (view as CraftView).type = item.tag
        view.textViewName.text = item.name

        return view
    }
}