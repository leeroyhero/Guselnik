package ru.bogdanov.guselnik.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.bogdanov.guselnik.App

@Module
class AppModule {
    @Provides
    fun provideContext(): Context = App.context
}