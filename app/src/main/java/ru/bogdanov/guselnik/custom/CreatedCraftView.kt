package ru.bogdanov.guselnik.custom

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.FrameLayout
import ru.bogdanov.guselnik.R
import ru.bogdanov.guselnik.craftUtils.getCenter
import ru.bogdanov.guselnik.item.CraftDraft
import kotlin.random.Random

class CreatedCraftView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MovableCraftView(context, attrs, defStyleAttr) {
    private val view: View

    init {
        view = View.inflate(context, R.layout.created_craft_view, this)
        view.layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
    }

    fun setCorrectPosition(draft:CraftDraft, field: FrameLayout) {
        if (draft.needToanimateDown)
            post {
                x=draft.xPos-width/2
                y=draft.yPos-height/2
                animate()
                    .x(x + Random.nextInt(-50, 50))
                    .y(y + 400f + Random.nextInt(-100, 100))
                    .setInterpolator(DecelerateInterpolator())
                    .setDuration(200)
                    .withStartAction {
                        visibility = View.VISIBLE
                    }
                    .start()
            }
        else {
            post {
                if (x+width>field.width){
                    x=(field.width-width/2-50).toFloat()
                    y=draft.yPos-height/2
                }else{
                    x=draft.xPos-width/2
                    y=draft.yPos-height/2
                }
                visibility = View.VISIBLE
            }
        }
    }
}