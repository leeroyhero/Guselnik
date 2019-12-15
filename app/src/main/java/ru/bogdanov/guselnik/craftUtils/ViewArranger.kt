package ru.bogdanov.guselnik.craftUtils

import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.FrameLayout
import ru.bogdanov.guselnik.custom.CreatedCraftView
import ru.bogdanov.guselnik.custom.MovableCraftView
import ru.bogdanov.guselnik.interfaces.DropListener
import ru.bogdanov.guselnik.item.CraftDraft
import kotlin.random.Random

class ViewArranger(val field: FrameLayout, val dropListener: DropListener) {
    fun arrangeView(view: CreatedCraftView, draft: CraftDraft) {
        val params = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )

        view.visibility=View.INVISIBLE

        params.leftMargin = draft.xPos.toInt()
        params.topMargin = draft.yPos.toInt()

        field.addView(view, params)

        view.post{
            view.setCorrectPosition(field, draft.needToanimateDown)
        }

        (view as MovableCraftView).setDropListener(dropListener)
    }


}