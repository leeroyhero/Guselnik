package ru.bogdanov.guselnik.viewModel

import android.view.View
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.bogdanov.guselnik.craftUtils.Recipe
import ru.bogdanov.guselnik.custom.CraftView
import ru.bogdanov.guselnik.item.CraftDraft


class CraftViewModel: ViewModel() {
    val viewToRemove=MutableLiveData<View>()
    val viewToCreate=MutableLiveData<CraftDraft>()

    private val recipe=Recipe()


    fun collisionDetected(dropped: View, view: View) {
        val droppedType=(dropped as CraftView).type
        val secondType=(view as CraftView).type

        if (needToDelete(droppedType, secondType)) viewToRemove.value=dropped
        else {
            val newViewType=recipe.getNewViewType(droppedType, secondType)
            Toast.makeText(dropped.context, "create new: $newViewType", Toast.LENGTH_SHORT).show()
            if (!newViewType.equals("none")) createNewView(newViewType, dropped,view)
        }
    }

    private fun createNewView(newViewType: String, view1: CraftView, view2: CraftView) {

    }

    private fun needToDelete(droppedType: String, secondType: String):Boolean{
        return secondType.equals("trash")&&
                (!droppedType.equals("knife")&&!droppedType.equals("axe")&&!droppedType.equals("chisel"))
    }

}