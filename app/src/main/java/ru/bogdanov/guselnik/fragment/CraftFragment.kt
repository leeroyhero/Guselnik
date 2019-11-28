package ru.bogdanov.guselnik.fragment


import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import kotlinx.android.synthetic.main.fragment_craft.view.*

import ru.bogdanov.guselnik.R
import ru.bogdanov.guselnik.interfaces.DropListener
import ru.bogdanov.guselnik.viewModel.CraftViewModel

/**
 * A simple [Fragment] subclass.
 */
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
    }

    override fun dropped(v: View, type: String, xPos: Float, yPos: Float) {
        Toast.makeText(context, "$type $xPos $yPos", Toast.LENGTH_SHORT).show()
    }
}
