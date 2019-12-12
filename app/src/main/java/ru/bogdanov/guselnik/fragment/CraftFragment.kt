package ru.bogdanov.guselnik.fragment


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_craft.*
import kotlinx.android.synthetic.main.fragment_craft.view.*

import ru.bogdanov.guselnik.R
import ru.bogdanov.guselnik.craftUtils.CollisionDetector
import ru.bogdanov.guselnik.craftUtils.CraftViewFactory
import ru.bogdanov.guselnik.craftUtils.ViewArranger
import ru.bogdanov.guselnik.interfaces.DropListener
import ru.bogdanov.guselnik.item.CraftDraft
import ru.bogdanov.guselnik.viewModel.CraftViewModel

class CraftFragment : Fragment(), DropListener {
    val model = viewModels<CraftViewModel>()
    private val viewFactory = CraftViewFactory()
    private lateinit var arranger: ViewArranger
    private lateinit var collision: CollisionDetector


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_craft, container, false)
        view.axe.setDropListener(this)
        view.knife.setDropListener(this)
        view.chisel.setDropListener(this)
        arranger = ViewArranger(view.arrangeField, this)
        collision = CollisionDetector(view.arrangeField, arrayOf(view.forest, view.bonfire))
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        model.value.viewToRemove.observe(this, Observer { removeView(it) })
        model.value.viewToCreate.observe(this, Observer { createView(it) })
        model.value.newInstrument.observe(this, Observer {
            notification.show(it.label)
        })
    }

    private fun createView(draft: CraftDraft) {
        val view = viewFactory.getView(draft.ingredient, context)
        if (view != null) arranger.arrangeView(view, draft)
    }

    private fun removeView(view: View) {
        arrangeField.removeView(view)
    }

    override fun dropped(droppedView: View) {
        val collisionView = collision.findCollision(droppedView)
        if (collisionView != null) model.value.collisionDetected(droppedView, collisionView)
    }
}
