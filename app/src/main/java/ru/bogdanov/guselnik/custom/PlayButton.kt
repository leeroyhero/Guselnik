package ru.bogdanov.guselnik.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.play_button.view.*
import ru.bogdanov.guselnik.R
import ru.bogdanov.guselnik.item.Ingredient

class PlayButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    lateinit var view: View
    init {
        view= View.inflate(context, R.layout.play_button, this)
        orientation=LinearLayout.VERTICAL
    }

    fun instrumentChosen(ingredient: Ingredient) {
        if (ingredient.image!=null) view.imageViewIcon.setImageResource(ingredient.image)
    }
}