package ru.bogdanov.guselnik.fragment


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

import ru.bogdanov.guselnik.R
import ru.bogdanov.guselnik.viewModel.CraftViewModel

/**
 * A simple [Fragment] subclass.
 */
class CraftFragment : Fragment() {
    val model = viewModels<CraftViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_craft, container, false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
}
