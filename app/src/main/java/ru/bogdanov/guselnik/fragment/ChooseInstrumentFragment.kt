package ru.bogdanov.guselnik.fragment

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.choose_instrument_fragment.*

import ru.bogdanov.guselnik.R
import ru.bogdanov.guselnik.adapter.OpenedInstrumentsAdapter
import ru.bogdanov.guselnik.item.Ingredient
import ru.bogdanov.guselnik.viewModel.ChooseInstrumentPresenter
import ru.bogdanov.guselnik.viewModel.PlayPresenter

class ChooseInstrumentFragment : Fragment() {
    private val model: ChooseInstrumentPresenter by activityViewModels()
    private val modelPlay: PlayPresenter by activityViewModels()
    private var adapter: OpenedInstrumentsAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.choose_instrument_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        model.instrumentListData.observe(this, Observer {
            showInstruments(it)
        })
        model.loadOpenedInstruments()
    }

    private fun showInstruments(arrayOfIngredients: Array<Ingredient>) {
        if (arrayOfIngredients.isNullOrEmpty()) placeholderChosen.visibility=View.VISIBLE
        else {
            recyclerInstruments.layoutManager =
                GridLayoutManager(context, 3, RecyclerView.VERTICAL, false)
            adapter = OpenedInstrumentsAdapter(arrayOfIngredients) {
                modelPlay.chosenInstruments = it
            }
            recyclerInstruments.adapter = adapter
            placeholderChosen.visibility=View.INVISIBLE
        }
    }
}
