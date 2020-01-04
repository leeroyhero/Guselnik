package ru.bogdanov.guselnik.di

import dagger.Component
import ru.bogdanov.guselnik.craftUtils.CraftItemCombiner
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {
 fun gerItemCombiner():CraftItemCombiner
}