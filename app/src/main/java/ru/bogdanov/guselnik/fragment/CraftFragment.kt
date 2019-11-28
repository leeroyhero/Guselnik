package ru.bogdanov.guselnik.fragment


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_craft.*
import kotlinx.android.synthetic.main.fragment_craft.view.*

import ru.bogdanov.guselnik.R
import ru.bogdanov.guselnik.craftUtils.checkCollision
import ru.bogdanov.guselnik.interfaces.DropListener
import ru.bogdanov.guselnik.viewModel.CraftViewModel

class CraftFragment : Fragment(),DropListener {
    val model = viewModels<CraftViewModel>()

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
        model.value.viewToCreate.observe(this, Observer {  })
    }

    private fun removeView(view: View) {
        arrangeField.removeView(view)
    }

    override fun dropped(droppedView: View) {
        for (index in 0 until (arrangeField.childCount)){
            val view=arrangeField.getChildAt(index)
            if (droppedView!=view&& checkCollision(view, droppedView))
            {
                model.value.collisionDetected(droppedView, view)
                break
            }
        }
    }
}
