package ru.bogdanov.guselnik.di

import dagger.Component
import ru.bogdanov.guselnik.fragment.PlayFragment
import ru.bogdanov.guselnik.viewModel.ChooseInstrumentPresenter
import ru.bogdanov.guselnik.viewModel.CraftViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [CraftModule::class, AppModule::class])
interface AppComponent {
    fun inject(craftViewModel: CraftViewModel)
    fun inject(craftViewModel: PlayFragment)
    fun inject(chooseInstrumentPresenter: ChooseInstrumentPresenter)
}