package ru.bogdanov.guselnik.viewModel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.bogdanov.guselnik.craftUtils.*
import ru.bogdanov.guselnik.custom.FieldObject
import ru.bogdanov.guselnik.item.CraftDraft
import ru.bogdanov.guselnik.item.CraftItem
import ru.bogdanov.guselnik.item.Ingredient


class CraftViewModel : ViewModel() {
    val viewToRemove = MutableLiveData<View>()
    val viewToCreate = MutableLiveData<CraftDraft>()
    val newInstrument = MutableLiveData<Ingredient>()

    private val recipe = Recipe()


    fun collisionDetected(dropped: View, view: View) {
        val droppedType = (dropped as CraftItem).type
        val secondType = (view as CraftItem).type

        if (canCraft(secondType)) {

            val needToAnimateDown: Boolean = secondType.equals("forest")

            if (needToDelete(droppedType, secondType)) {
                viewToRemove.value = dropped
            } else {
                val craftItem = recipe.getNewViewType(droppedType, secondType)

                if (craftItem!=null) {
                    removeIngredients(dropped, view, droppedType, secondType)

                    createNewView(
                        craftItem,
                        dropped,
                        view,
                        needToAnimateDown
                    )
                }
            }
        }
    }

    private fun canCraft(secondType: String): Boolean {
        return !secondType.equals("axe")&&!secondType.equals("knife")&&!secondType.equals("chisel")
    }

    private fun removeIngredients(
        dropped: View,
        view: View,
        droppedType: String,
        secondType: String
    ) {
        if (!secondType.equals("forest")&&(droppedType.equals("knife") ||droppedType.equals("axe") ||droppedType.equals("chisel"))) viewToRemove.value=view

        if (!secondType.equals("forest")&&(!droppedType.equals("knife") && !droppedType.equals("axe") && !droppedType.equals("chisel"))) {
            viewToRemove.value=view
            viewToRemove.value=dropped
        }
    }

    private fun createNewView(
        recipeItem: Ingredient,
        droppedView: View,
        view2: View,
        needToAnimateDown: Boolean
    ) {
        var coordinates:Pair<Float, Float>?=null
        if (needToAnimateDown) coordinates=droppedView.getCenter()
        else coordinates= getCoordinates(droppedView, view2)

        viewToCreate.value = CraftDraft(recipeItem, coordinates.first, coordinates.second, needToAnimateDown)
    }

    private fun needToDelete(droppedType: String, secondType: String): Boolean {
        return secondType.equals("trash") &&
                (!droppedType.equals("knife") && !droppedType.equals("axe") && !droppedType.equals("chisel"))
    }

}