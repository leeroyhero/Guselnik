package ru.bogdanov.guselnik.craftUtils

import android.content.Context
import android.view.View
import kotlinx.android.synthetic.main.created_craft_view.view.*
import ru.bogdanov.guselnik.custom.CraftView
import ru.bogdanov.guselnik.custom.CreatedCraftView

class CraftViewFactory {
    fun getView(type: String, context:Context?): View? {
        if (context==null) return null

        val view=CreatedCraftView(context)
        (view as CraftView).type=type
        view.textViewName.text=getItemName(type)

        return view
    }

    private fun getItemName(type: String): String {
        return when(type){
            "log"->"полено"
            "cane"->"тростник"
            "bark"->"кора"
            "plank"->"доска"
            "sliver"->"щепка"
            "peg"->"колок"

            "stick"->"палка"
            "neck"->"гриф"

            else->"Хлам"
        }
    }
}