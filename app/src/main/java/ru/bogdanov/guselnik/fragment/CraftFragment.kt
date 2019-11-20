package ru.bogdanov.guselnik.fragment


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_craft.*
import kotlinx.android.synthetic.main.fragment_craft.view.*
import org.jetbrains.anko.sdk27.coroutines.onTouch

import ru.bogdanov.guselnik.R
import ru.bogdanov.guselnik.craftUtils.ObjectArranger
import ru.bogdanov.guselnik.viewModel.CraftViewModel

/**
 * A simple [Fragment] subclass.
 */
class CraftFragment : Fragment() {
    val model = viewModels<CraftViewModel>()
    lateinit var arranger: ObjectArranger
    private val posOffset=IntArray(2)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_craft, container, false)
        arranger = ObjectArranger(view.arrangeField)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        arrangeField.post {
            arrangeField.getLocationOnScreen(posOffset)
        }

        model.value.newObject.observe(this, Observer {
            arranger.createObject(it)
        })

        arrangeField.onTouch { v, event ->
            if (event.action==MotionEvent.ACTION_DOWN) model.value.clicked(event, posOffset)
        }
    }
}
