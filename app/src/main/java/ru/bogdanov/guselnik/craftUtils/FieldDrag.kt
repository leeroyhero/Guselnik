package ru.bogdanov.guselnik.craftUtils

import android.util.Log
import android.view.DragEvent
import android.view.View
import ru.bogdanov.guselnik.custom.ObjectView

class FieldDrag (){
    fun dragEvent(view: View, dragEvent: DragEvent){
        when (dragEvent.action){
            DragEvent.ACTION_DROP->{
                Log.d("dragEvent", "${dragEvent.localState as? View} ${dragEvent.x} ${dragEvent.y} ")
                if (dragEvent.localState!=null){
                    val v=dragEvent.localState as View
                    if (v.tag.equals("item"))
                    {
                        (v as ObjectView).place(dragEvent.x, dragEvent.y)
                    }
                }
            }
        }
    }
}

