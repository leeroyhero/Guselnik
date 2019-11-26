package ru.bogdanov.guselnik.craftUtils

import android.view.View
import android.widget.FrameLayout
import ru.bogdanov.guselnik.custom.ObjectView
import ru.bogdanov.guselnik.item.ObjectForCreation

class ObjectArranger(val field: FrameLayout) {
    fun createObject(
        objectForCreation: ObjectForCreation
    ) {
        val objectView=ObjectView(field.context)
        field.addView(objectView)
        objectView.place(objectForCreation.posX, objectForCreation.posY)
    }
}