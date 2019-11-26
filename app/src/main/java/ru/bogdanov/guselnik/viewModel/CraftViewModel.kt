package ru.bogdanov.guselnik.viewModel

import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.bogdanov.guselnik.craftUtils.FieldDrag
import ru.bogdanov.guselnik.item.ObjectForCreation
import ru.bogdanov.guselnik.item.ObjectType

class CraftViewModel: ViewModel() {
    fun clicked(event: MotionEvent, posOffset: IntArray) {

        newObject.value= ObjectForCreation(
            event.rawX-posOffset[0],
            event.rawY-posOffset[1],
            ObjectType.Poleno
        )
    }

    fun dragEvent(v: View, event: DragEvent): Boolean {
        when(v.tag){
            "field"-> FieldDrag().dragEvent(v, event)
        }
        return true
    }

    val newObject=MutableLiveData<ObjectForCreation>()
}