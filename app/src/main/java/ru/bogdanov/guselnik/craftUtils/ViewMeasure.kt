package ru.bogdanov.guselnik.craftUtils

import android.view.View

//x, y
fun View.getCenter():Pair<Float, Float>{
    return Pair(
        this.x+this.width/2,
        this.y+this.height/2
    )
}

fun getCoordinates(view1:View, view2:View):Pair<Float, Float>{
    val coord1=view1.getCenter()
    val coord2=view2.getCenter()

    return Pair(
        (coord1.first+coord2.first)/2,
        (coord1.second+coord2.second)/2
    )
}