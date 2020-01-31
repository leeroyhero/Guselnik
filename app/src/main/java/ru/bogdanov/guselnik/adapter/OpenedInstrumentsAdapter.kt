package ru.bogdanov.guselnik.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.opened_item.view.*
import ru.bogdanov.guselnik.R
import ru.bogdanov.guselnik.item.Ingredient

class OpenedInstrumentsAdapter(val array: Array<Ingredient>):
    RecyclerView.Adapter<OpenedInstrumentsAdapter.OpenedInstrumentViewHolder>() {
    class OpenedInstrumentViewHolder(val view: View):RecyclerView.ViewHolder(view){
        val icon=view.imageViewIcon
        val name=view.textViewName
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OpenedInstrumentViewHolder {
        return OpenedInstrumentViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.opened_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return array.size
    }

    override fun onBindViewHolder(holder: OpenedInstrumentViewHolder, position: Int) {
        val ingredient=array[position]

        holder.name.text=ingredient.label
    }
}