package ru.bogdanov.guselnik

import android.app.Application
import android.content.Context
import ru.bogdanov.guselnik.di.DaggerAppComponent

class App : Application() {
    companion object {
        val appComponent = DaggerAppComponent.create()
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}