package ru.bogdanov.guselnik.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.new_notification.view.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import ru.bogdanov.guselnik.R

class NewInstrumentNotification @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    val view = View.inflate(context, R.layout.new_notification, this)

    fun show(name: String) {
        alpha = 0f
        view.textViewInstrumentName.text = name

        animate()
            .alpha(1f)
            .withStartAction { visibility=View.VISIBLE }
            .setDuration(200)
            .start()
        MainScope().launch {
            delay(3000)
            animate()
                .alpha(0f)
                .setDuration(200)
                .withEndAction { visibility=View.GONE }
                .start()
        }
    }
}