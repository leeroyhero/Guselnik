package ru.bogdanov.guselnik.utils

import android.content.Context

fun Int.pixToDp(context: Context):Int{
    return (this*context.resources.displayMetrics.density).toInt()
}