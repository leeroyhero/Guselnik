package ru.bogdanov.guselnik.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.FrameLayout
import ru.bogdanov.guselnik.R
import ru.bogdanov.guselnik.craftUtils.getCenter
import kotlin.random.Random

class CreatedCraftView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MovableCraftView(context, attrs, defStyleAttr) {
    private val view: View

    init {
        view = View.inflate(context, R.layout.created_craft_view, this)
        view.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
    }

    fun setCorrectPosition(field: FrameLayout, needToanimateDown: Boolean) {
        val center=getCenter()

        if (needToanimateDown)
            view.post {
                view.animate()
                    .x(center.first + Random.nextInt(-50, 50))
                    .y(center.second + 300f + Random.nextInt(-100, 100))
                    .setInterpolator(DecelerateInterpolator())
                    .setDuration(200)
                    .start()
            }
        else {

        }

        visibility=View.VISIBLE
    }
}