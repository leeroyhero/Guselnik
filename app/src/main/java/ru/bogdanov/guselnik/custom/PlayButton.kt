package ru.bogdanov.guselnik.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import ru.bogdanov.guselnik.R

class PlayButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    lateinit var view: View
    init {
        view= View.inflate(context, R.layout.play_button, this)
        orientation=LinearLayout.VERTICAL
    }
}