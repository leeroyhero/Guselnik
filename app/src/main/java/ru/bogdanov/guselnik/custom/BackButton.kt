package ru.bogdanov.guselnik.custom

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.FrameLayout
import androidx.navigation.findNavController
import org.jetbrains.anko.sdk27.coroutines.onClick
import ru.bogdanov.guselnik.R

class BackButton @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        View.inflate(context, R.layout.back_button, this)
        onClick { findNavController().popBackStack() }

        val outValue=TypedValue()
        context.theme.resolveAttribute(android.R.attr.selectableItemBackground, outValue, true)
        setBackgroundResource(outValue.resourceId)
    }
}