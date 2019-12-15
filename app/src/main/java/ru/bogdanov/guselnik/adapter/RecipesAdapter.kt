package ru.bogdanov.guselnik.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recipes_item.view.*
import ru.bogdanov.guselnik.R
import ru.bogdanov.guselnik.item.RecipeItem

class RecipesAdapter(val list:MutableList<RecipeItem>): RecyclerView.Adapter<RecipesAdapter.RecipesViewHolder>() {

    class RecipesViewHolder(v: View): RecyclerView.ViewHolder(v) {
        val result=v.textViewResult
        val ingr1=v.textViewIngredient1
        val ingr2=v.textViewIngredient2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesViewHolder {
        return RecipesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.recipes_item, parent, false)
        )
    }

    override fun getItemCount(): Int =list.size

    override fun onBindViewHolder(holder: RecipesViewHolder, position: Int) {
        val recipeItem=list[position]
        holder.result.text=recipeItem.result.label
        holder.ingr1.text=recipeItem.ingredient1.label
        holder.ingr2.text=recipeItem.ingredient2.label
    }
}