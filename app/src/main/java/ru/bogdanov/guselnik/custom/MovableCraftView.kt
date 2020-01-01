package ru.bogdanov.guselnik.custom

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import ru.bogdanov.guselnik.R
import ru.bogdanov.guselnik.craftUtils.NONE
import ru.bogdanov.guselnik.craftUtils.TouchEvent
import ru.bogdanov.guselnik.interfaces.DropListener
import ru.bogdanov.guselnik.item.CraftItem

open class MovableCraftView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), CraftItem {
    private var returnable=false
    private val touchEvent:TouchEvent

    override var type: String= NONE

    init {
        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.MovableCraftView)
            returnable=typedArray.getBoolean(R.styleable.MovableCraftView_returnable, false)
            type = typedArray.getString(R.styleable.MovableCraftView_type) ?: NONE

            typedArray.recycle()
        }
        touchEvent=TouchEvent(returnable)

        setOnTouchListener(touchEvent.touchListener)
    }

    fun setDropListener(listener:DropListener){
        touchEvent.setDropListener(listener)
    }
}