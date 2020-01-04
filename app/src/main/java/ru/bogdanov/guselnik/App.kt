package ru.bogdanov.guselnik

import android.app.Application
import ru.bogdanov.guselnik.di.DaggerAppComponent

class App:Application() {
    companion object {
        val appComponent= DaggerAppComponent.create()
    }
}