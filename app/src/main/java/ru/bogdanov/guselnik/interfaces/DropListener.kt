package ru.bogdanov.guselnik.interfaces

import android.view.View

interface DropListener {
    fun dropped(v: View, type:String, xPos:Float, yPos:Float)
}