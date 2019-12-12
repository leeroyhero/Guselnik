package ru.bogdanov.guselnik.craftUtils

import android.view.View
import android.widget.FrameLayout

class Collision(val field: FrameLayout, val dropObjects: Array<View>) {

    fun findCollision(dropped: View): View? {
        val list = prepareObjectList()
        val collisionView = find(dropped, list)
        return collisionView
    }

    private fun find(dropped: View, list: MutableList<View>): View? {
        for (view in list){
            if (isCollision(view, dropped))
                if (view!=dropped)
                    return view
        }
        return null
    }

    private fun prepareObjectList(): MutableList<View> {
        val list = dropObjects.toMutableList()
        repeat(field.childCount) {
            list.add(field.getChildAt(it))
        }
        return list
    }

    fun isCollision(view: View, droppedView: View): Boolean {
        val x = droppedView.x + droppedView.width / 2
        val y = droppedView.y + droppedView.height / 2

        if (x < view.x) return false
        if (y < view.y) return false
        if (x > (view.x + view.width)) return false
        if (y > (view.y + view.height)) return false

        return true
    }
}

