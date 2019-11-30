package ru.bogdanov.guselnik.viewModel

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.bogdanov.guselnik.craftUtils.CraftViewFactory
import ru.bogdanov.guselnik.craftUtils.Recipe
import ru.bogdanov.guselnik.craftUtils.getCenter
import ru.bogdanov.guselnik.craftUtils.getCoordinates
import ru.bogdanov.guselnik.custom.CraftView
import ru.bogdanov.guselnik.item.CraftDraft


class CraftViewModel : ViewModel() {
    val viewToRemove = MutableLiveData<View>()
    val viewToCreate = MutableLiveData<CraftDraft>()

    private val recipe = Recipe()

    fun collisionDetected(dropped: View, view: View) {
        val droppedType = (dropped as CraftView).type
        val secondType = (view as CraftView).type

        val needToAnimateDown: Boolean = secondType.equals("forest")

        if (needToDelete(droppedType, secondType)) {
            viewToRemove.value = dropped
        }
        else {
            val newViewType = recipe.getNewViewType(droppedType, secondType)

            if (!newViewType.equals("none")) {
                removeIngredients(dropped, view, droppedType, secondType)

                createNewView(
                    newViewType,
                    dropped,
                    view,
                    needToAnimateDown
                )
            }
        }
    }

    private fun removeIngredients(
        dropped: CraftView,
        view: CraftView,
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
        newViewType: String,
        droppedView: CraftView,
        view2: CraftView,
        needToAnimateDown: Boolean
    ) {
        var coordinates:Pair<Float, Float>?=null
        if (needToAnimateDown) coordinates=droppedView.getCenter()
        else coordinates= getCoordinates(droppedView, view2)

        viewToCreate.value = CraftDraft(newViewType, coordinates.first, coordinates.second, needToAnimateDown)
    }

    private fun needToDelete(droppedType: String, secondType: String): Boolean {
        return secondType.equals("trash") &&
                (!droppedType.equals("knife") && !droppedType.equals("axe") && !droppedType.equals("chisel"))
    }

}