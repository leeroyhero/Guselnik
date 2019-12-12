package ru.bogdanov.guselnik.craftUtils

import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.FrameLayout
import ru.bogdanov.guselnik.custom.MovableCraftView
import ru.bogdanov.guselnik.interfaces.DropListener
import ru.bogdanov.guselnik.item.CraftDraft
import ru.bogdanov.guselnik.item.Instrument
import kotlin.random.Random

class ViewArranger(val field: FrameLayout, val dropListener: DropListener) {
    fun addView(view: View, draft: CraftDraft) {
        val params = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )
        params.leftMargin = draft.xPos.toInt()
        params.topMargin = draft.yPos.toInt()

        field.addView(view, params)

        if (draft.needToanimateDown)
            view.post {
                view.animate()
                    .x(draft.xPos + Random.nextInt(-50, 50))
                    .y(draft.yPos + 300f + Random.nextInt(-100, 100))
                    .setInterpolator(DecelerateInterpolator())
                    .setDuration(200)
                    .start()
            }


        (view as MovableCraftView).setDropListener(dropListener)
    }


}