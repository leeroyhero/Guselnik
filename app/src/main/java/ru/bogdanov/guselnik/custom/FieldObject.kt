package ru.bogdanov.guselnik.custom

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import ru.bogdanov.guselnik.R
import ru.bogdanov.guselnik.craftUtils.NONE
import ru.bogdanov.guselnik.item.CraftItem

class FieldObject @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), CraftItem {

    override var type: String= NONE
        get() = field
        set(value) {field=value}

    init {
        if (attrs != null) {
            val typedArray = context.obtainStyledAttributes(attrs, R.styleable.FieldObject)
            type = typedArray.getString(R.styleable.FieldObject_type) ?: "none"

            typedArray.recycle()
        }
    }


}