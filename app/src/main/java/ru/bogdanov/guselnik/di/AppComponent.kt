package ru.bogdanov.guselnik.di

import dagger.Component
import ru.bogdanov.guselnik.craftUtils.CraftItemCombiner
import ru.bogdanov.guselnik.viewModel.CraftViewModel
import javax.inject.Singleton

@Singleton
@Component
interface AppComponent {
    fun inject(craftViewModel:CraftViewModel)
}