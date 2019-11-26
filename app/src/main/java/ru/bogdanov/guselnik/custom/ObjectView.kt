package ru.bogdanov.guselnik.custom

import android.content.ClipData
import android.content.ClipDescription
import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.os.Build
import android.util.AttributeSet
import android.util.Log
import android.view.DragEvent
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.setPadding
import ru.bogdanov.guselnik.R

class ObjectView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private var dX = 0f
    private var dY = 0f
    private var wid = 300
    private var hei = 200

    init {
        layoutParams = LayoutParams(wid, hei)

        tag="item"

        val shape = GradientDrawable().apply {
            shape = GradientDrawable.RECTANGLE
            cornerRadius = 30f
            setStroke(
                5, ContextCompat.getColor(
                    context,
                    R.color.material_border
                )
            )
        }
        background = shape

        setPadding(24)

        val textView = TextView(context).apply {
            text = "Щепка"
            val params = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
            params.gravity = Gravity.CENTER
            layoutParams = params
        }

        addView(textView)

        setOnTouchListener { v, event ->
            touchEvent(v, event)
        }
    }

    private fun touchEvent(v: View, event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                val dragData=ClipData.newPlainText("123","456")
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    startDragAndDrop(
                        dragData,
                        DragShadowBuilder(this),
                        this,
                        0
                    )
                } else {
                    startDrag(
                        dragData,
                        DragShadowBuilder(this),
                        this,
                        0
                    )
                }

                visibility=View.INVISIBLE
                return true
            }
            else -> return false
        }
    }

    fun place(posX: Float, posY: Float) {
        animate()
            .x(posX - wid / 2)
            .y(posY - hei / 2)
            .setDuration(0)
            .start()
        visibility=View.VISIBLE
    }
}