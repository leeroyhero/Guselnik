package ru.bogdanov.guselnik.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import ru.bogdanov.guselnik.R

class CreatedCraftView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MovableCraftView(context, attrs, defStyleAttr) {

    private val view: View

    init {
        view = View.inflate(context, R.layout.created_craft_view, this)
        view.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
    }
}