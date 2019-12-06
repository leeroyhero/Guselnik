package ru.bogdanov.guselnik.fragment


import android.os.Bundle
import android.view.*
import android.view.animation.DecelerateInterpolator
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.craft_field.*
import kotlinx.android.synthetic.main.craft_field.view.*
import kotlinx.android.synthetic.main.fragment_craft.*
import kotlinx.android.synthetic.main.fragment_craft.view.*

import ru.bogdanov.guselnik.R
import ru.bogdanov.guselnik.craftUtils.CraftViewFactory
import ru.bogdanov.guselnik.craftUtils.animateProgress
import ru.bogdanov.guselnik.craftUtils.checkCollision
import ru.bogdanov.guselnik.custom.MovableCraftView
import ru.bogdanov.guselnik.interfaces.DropListener
import ru.bogdanov.guselnik.item.CraftDraft
import ru.bogdanov.guselnik.item.Instrument
import ru.bogdanov.guselnik.viewModel.CraftViewModel
import kotlin.random.Random

class CraftFragment : Fragment(), DropListener {
    val model = viewModels<CraftViewModel>()
    private val viewFactory = CraftViewFactory()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_craft, container, false)
        view.axe.setDropListener(this)
        view.knife.setDropListener(this)
        view.chisel.setDropListener(this)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        model.value.viewToRemove.observe(this, Observer { removeView(it) })
        model.value.viewToCreate.observe(this, Observer { createView(it) })
        model.value.getCount { opened, max ->
            progressBarOpenCount.animateProgress(opened, max)
            textViewOpenCount.text = "$opened/$max"
        }
        model.value.newInstrument.observe(this, Observer {
            model.value.getCount { opened, max ->
                newInstrumentOpen(it, opened, max)
            }
        })
    }

    private fun newInstrumentOpen(instrument: Instrument, openCount: Int, instrumentCount: Int) {
        progressBarOpenCount.animateProgress(openCount, instrumentCount)
        textViewOpenCount.text = "$openCount/$instrumentCount"
        notification.show(instrument.name)
    }

    private fun createView(draft: CraftDraft) {
        val view = viewFactory.getView(draft.recipeItem, context)
        if (view != null) {
            val params = FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.WRAP_CONTENT,
                FrameLayout.LayoutParams.WRAP_CONTENT
            )
            params.leftMargin = draft.xPos.toInt()
            params.topMargin = draft.yPos.toInt()

            arrangeField.addView(view, params)

            if (draft.needToanimateDown)
                view.post {
                    view.animate()
                        .x(draft.xPos + Random.nextInt(-50, 50))
                        .y(draft.yPos + 300f + Random.nextInt(-100, 100))
                        .setInterpolator(DecelerateInterpolator())
                        .setDuration(200)
                        .start()
                }


            (view as MovableCraftView).setDropListener(this)

            if (draft.recipeItem is Instrument) {
                model.value.checkNewInstrumentOpened(draft.recipeItem)
            }
        }
    }

    private fun removeView(view: View) {
        arrangeField.removeView(view)
    }

    override fun dropped(droppedView: View) {
        for (index in 0 until (arrangeField.childCount)) {
            val view = arrangeField.getChildAt(index)
            if (droppedView != view && checkCollision(view, droppedView)) {
                model.value.collisionDetected(droppedView, view)
                break
            }
        }
    }
}
