package ru.bogdanov.guselnik.craftUtils

import android.view.MotionEvent
import android.view.View
import android.view.animation.DecelerateInterpolator
import ru.bogdanov.guselnik.interfaces.DropListener
import ru.bogdanov.guselnik.utils.log

class TouchEvent(private val returnable: Boolean) {
    private var dX = 0f
    private var dY = 0f

    private var startX = 0f
    private var startY = 0f

    private var canTouch = true
    private var dropListener: DropListener? = null

    val touchListener = object : View.OnTouchListener {
        override fun onTouch(v: View, event: MotionEvent): Boolean {
            return touchEvent(v, event)
        }
    }

    private fun touchEvent(v: View, event: MotionEvent): Boolean {
        log(v.toString())
        if (!canTouch) return false
        else
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    v.z=15f

                    startX = v.x
                    startY = v.y

                    dX = v.x - event.rawX
                    dY = v.y - event.rawY

                    animateScale(v, 1.05f)
                    return true
                }
                MotionEvent.ACTION_MOVE -> {
                    v.animate()
                        .x(event.rawX + dX)
                        .y(event.rawY + dY)
                        .setDuration(0)
                        .start()
                    return true
                }
                MotionEvent.ACTION_UP -> {
                    dX = 0f
                    dY = 0f
                    v.z=0f

                    dropListener?.dropped(v)

                    animateScale(v, 1f)

                    if (returnable) returnBack(v)
                    return true
                }
                else -> return false
            }
    }

    private fun animateScale(view:View, scale:Float){
        view.animate()
            .setDuration(200)
            .setInterpolator(DecelerateInterpolator())
            .scaleX(scale)
            .scaleY(scale)
            .start()
    }

    private fun returnBack(v: View) {
        v.animate()
            .x(startX)
            .y(startY)
            .setDuration(200)
            .setInterpolator(DecelerateInterpolator())
            .withStartAction { canTouch = false }
            .withEndAction { canTouch = true }
            .start()
    }

    fun setDropListener(listener: DropListener) {
        if (dropListener==null)
        dropListener = listener
    }
}