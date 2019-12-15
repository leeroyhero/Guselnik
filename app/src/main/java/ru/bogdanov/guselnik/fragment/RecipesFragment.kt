package ru.bogdanov.guselnik.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_recipes.*

import ru.bogdanov.guselnik.R
import ru.bogdanov.guselnik.adapter.RecipesAdapter
import ru.bogdanov.guselnik.craftUtils.Recipe
import javax.inject.Inject

class RecipesFragment : Fragment() {
    //@Inject
    var recipe: Recipe=Recipe()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recipes, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recyclerRecipes.adapter = RecipesAdapter(recipe.recipeItemList)
    }


}
