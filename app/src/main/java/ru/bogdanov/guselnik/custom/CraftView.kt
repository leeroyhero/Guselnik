package ru.bogdanov.guselnik.custom

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import ru.bogdanov.guselnik.R

open class CraftView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    var type: String = "none"

    init {
        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CraftView)
            type = typedArray.getString(R.styleable.CraftView_type) ?: "none"

            typedArray.recycle()
        }
    }

}