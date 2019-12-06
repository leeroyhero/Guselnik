package ru.bogdanov.guselnik.craftUtils

import android.animation.ObjectAnimator
import android.view.animation.DecelerateInterpolator
import android.widget.ProgressBar

fun ProgressBar.animateProgress(progress:Int, max:Int){
    this.max=max*100
    val animation=ObjectAnimator.ofInt(this, "progress", this.progress, progress*100)
    animation.duration=300
    animation.interpolator=DecelerateInterpolator()
    animation.start()
}