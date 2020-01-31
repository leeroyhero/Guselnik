package ru.bogdanov.guselnik.di

import dagger.Module
import dagger.Provides
import ru.bogdanov.guselnik.craftUtils.Recipe
import ru.bogdanov.guselnik.utils.Sound
import javax.inject.Singleton

@Module
class CraftModule {
    @Provides
    @Singleton
    fun provideRecipe(): Recipe = Recipe()
}