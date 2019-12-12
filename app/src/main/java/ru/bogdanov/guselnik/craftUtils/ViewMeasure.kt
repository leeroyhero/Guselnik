package ru.bogdanov.guselnik.craftUtils

import android.view.View

//x, y
fun View.getCenter():Pair<Float, Float>{
    return Pair(
        this.x+this.width/2,
        this.y+this.height/2
    )
}