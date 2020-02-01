package ru.bogdanov.guselnik.fragment


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_craft.*
import kotlinx.android.synthetic.main.fragment_craft.view.*

import ru.bogdanov.guselnik.R
import ru.bogdanov.guselnik.craftUtils.CollisionDetector
import ru.bogdanov.guselnik.craftUtils.CraftViewFactory
import ru.bogdanov.guselnik.craftUtils.ViewArranger
import ru.bogdanov.guselnik.interfaces.CraftListener
import ru.bogdanov.guselnik.interfaces.DropListener
import ru.bogdanov.guselnik.item.CraftDraft
import ru.bogdanov.guselnik.item.Ingredient
import ru.bogdanov.guselnik.viewModel.CraftViewModel

class CraftFragment : Fragment(), DropListener, CraftListener {
    val model = activityViewModels<CraftViewModel>()
    private val viewFactory = CraftViewFactory()
    private lateinit var arranger: ViewArranger
    private lateinit var collision: CollisionDetector

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

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

        view.buttonPlayInstruments.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_craftFragment_to_playFragment))

        model.value.setCraftListener(this)
        return view
    }

    override fun createView(draft: CraftDraft) {
        val view = viewFactory.getView(draft.ingredient, context)
        if (view != null) arranger.arrangeView(view, draft)
    }

    override fun removeView(view: View) {
        view.animate()
            .setDuration(300)
            .alpha(0f)
            .scaleX(0.6f)
            .scaleY(0.6f)
            .withEndAction { arrangeField.removeView(view) }
            .start()
    }

    override fun newInstrumentOpened(ingredient: Ingredient) {
        notification.show(ingredient.label)
    }

    override fun dropped(droppedView: View) {
        val collisionView = collision.findCollision(droppedView)
        if (collisionView != null) model.value.collisionDetected(droppedView, collisionView)
    }
}
