package ru.bogdanov.guselnik.craftUtils

import android.view.MotionEvent
import android.view.View

class TouchEvent(private val returnable: Boolean) {
    private var dX = 0f
    private var dY = 0f

    val touchListener= object : View.OnTouchListener {
        override fun onTouch(v: View, event: MotionEvent): Boolean {
            return touchEvent(v,event)
        }
    }

    private fun touchEvent(v: View, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                dX = v.x - event.rawX
                dY = v.y - event.rawY
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
            MotionEvent.ACTION_UP->{
                if (returnable) returnBack(v)
                return true
            }
            else -> return false
        }
    }

    private fun returnBack(v: View) {
        v.animate()
            .x(x)
            .y(y)
            .setDuration(200)
            .start()
    }

}