package ru.bogdanov.guselnik.custom

import android.content.Context
import android.util.AttributeSet
import ru.bogdanov.guselnik.R
import ru.bogdanov.guselnik.craftUtils.TouchEvent

class MovableCraftView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : CraftView(context, attrs, defStyleAttr) {
    private var returnable=false
    private val touchEvent:TouchEvent

    init {
        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.MovableCraftView)
            returnable=typedArray.getBoolean(R.styleable.MovableCraftView_returnable, false)

            typedArray.recycle()
        }
        touchEvent=TouchEvent(returnable)

        setOnTouchListener(touchEvent.touchListener)
    }
}