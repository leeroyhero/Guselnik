package ru.bogdanov.guselnik.viewModel

import android.view.MotionEvent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
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

    val newObject=MutableLiveData<ObjectForCreation>()
}