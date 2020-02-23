package ru.bogdanov.guselnik.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.opened_item.view.*
import ru.bogdanov.guselnik.R
import ru.bogdanov.guselnik.item.Ingredient

class OpenedInstrumentsAdapter(val array: Array<Ingredient>,val chosenListListener:(Array<Ingredient>)->Unit):
    RecyclerView.Adapter<OpenedInstrumentsAdapter.OpenedInstrumentViewHolder>() {
    private val MAX=5
    private val checked= mutableSetOf<Int>()

    class OpenedInstrumentViewHolder(val view: View):RecyclerView.ViewHolder(view){
        val icon=view.imageViewIcon
        val name=view.textViewName
        val check = view.imageViewCheck
    }

    private fun getCheckedList():Array<Ingredient>{
        return checked.toList().map { array[it] }.toTypedArray()
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
        if (ingredient.image!=null) holder.icon.setImageResource(ingredient.image)
        if (checked.contains(position)) holder.check.visibility=View.VISIBLE
        else holder.check.visibility=View.INVISIBLE
        holder.itemView.setOnClickListener {
            clicked(position)
        }
    }

    private fun clicked(position: Int) {
        if (checked.contains(position)){
            checked.remove(position)
        } else {
            if (checked.size<MAX)
            checked.add(position)
        }
        notifyItemChanged(position)
        chosenListListener(getCheckedList())
    }
}

