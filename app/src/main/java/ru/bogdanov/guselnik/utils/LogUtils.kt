package ru.bogdanov.guselnik.utils

import android.util.Log
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

fun Any.log(text:String){
    Log.d(this.javaClass.simpleName, text)
}