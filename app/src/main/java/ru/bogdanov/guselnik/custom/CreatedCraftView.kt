package ru.bogdanov.guselnik.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.DecelerateInterpolator
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.created_craft_view.view.*
import ru.bogdanov.guselnik.R
import ru.bogdanov.guselnik.item.AnimVector
import ru.bogdanov.guselnik.item.CraftDraft
import ru.bogdanov.guselnik.item.Ingredient
import ru.bogdanov.guselnik.utils.pixToDp
import kotlin.random.Random

class CreatedCraftView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MovableCraftView(context, attrs, defStyleAttr) {
    private val view: View

    init {
        view = View.inflate(context, R.layout.created_craft_view, this)
        layoutParams = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT)
    }

    fun setInfo(ingredient: Ingredient) {
        view.textViewName.text = ingredient.label
        if (ingredient.image != null) view.imageViewIngredientIcon.setImageResource(ingredient.image)
    }

    fun setCorrectPosition(draft: CraftDraft, field: FrameLayout) {
        if (draft.animVector != AnimVector.NONE)
            post {
                x = draft.xPos - width / 2
                y = draft.yPos - height / 2
                animate()
                    .x(x + draft.animVector.x + Random.nextInt(-50, 50))
                    .y(y + draft.animVector.y + Random.nextInt(-50, 50))
                    .setInterpolator(DecelerateInterpolator())
                    .setDuration(200)
                    .withStartAction {
                        visibility = View.VISIBLE
                    }
                    .start()
            }
        else {
            post {
                if (x + width > field.width) {
                    x = (field.width - width / 2 - 50).toFloat()
                    y = draft.yPos - height / 2
                } else {
                    x = draft.xPos - width / 2
                    y = draft.yPos - height / 2
                }
                visibility = View.VISIBLE
            }
        }
    }
}