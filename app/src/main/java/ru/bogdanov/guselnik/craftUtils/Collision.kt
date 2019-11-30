package ru.bogdanov.guselnik.craftUtils

import android.util.Log
import android.view.View
import ru.bogdanov.guselnik.custom.CraftView

fun checkCollision(view: View, droppedView:View ):Boolean{
    val x=droppedView.x+droppedView.width/2
    val y=droppedView.y+droppedView.height/2

    if (x<view.x) return false
    if (y<view.y) return false
    if (x>(view.x+view.width)) return false
    if (y>(view.y+view.height)) return false

    return true
}