package ru.bogdanov.guselnik.craftUtils

import android.util.Log
import android.view.View

//x, y
fun View.getCenter():Pair<Float, Float>{
    Log.d("getCenter", "${this.x} ${this.y} ${this.width} ${this.height}")
    return Pair(
        this.x+this.width/2,
        this.y+this.height/2
    )
}