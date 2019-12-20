package ru.bogdanov.guselnik.craftUtils

import android.view.View
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.FrameLayout
import ru.bogdanov.guselnik.custom.CreatedCraftView
import ru.bogdanov.guselnik.custom.MovableCraftView
import ru.bogdanov.guselnik.interfaces.DropListener
import ru.bogdanov.guselnik.item.CraftDraft
import kotlin.random.Random

class ViewArranger(val field: FrameLayout, val dropListener: DropListener) {
    fun arrangeView(view: CreatedCraftView, draft: CraftDraft) {
        view.visibility = View.INVISIBLE

        field.addView(view)

        view.post {
            view.setCorrectPosition(draft, field)
        }

        (view as MovableCraftView).setDropListener(dropListener)

        view.animate()
            .withStartAction {
                view.apply {
                    alpha=0f
                    scaleX=0.6f
                    scaleY=0.6f
                }
            }
            .setDuration(200)
            .setInterpolator(DecelerateInterpolator())
            .alpha(1f)
            .scaleX(1.05f)
            .scaleY(1.05f)
            .withEndAction {
                view.animate()
                    .setDuration(200)
                    .scaleX(1f)
                    .setInterpolator(AccelerateInterpolator())
                    .scaleY(1f)
                    .start()
            }
            .start()
    }


}