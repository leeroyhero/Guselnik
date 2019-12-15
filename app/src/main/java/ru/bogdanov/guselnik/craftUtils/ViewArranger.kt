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

        field.addView(view)

        view.post{
            view.setCorrectPosition(draft, field)
        }

        (view as MovableCraftView).setDropListener(dropListener)
    }


}