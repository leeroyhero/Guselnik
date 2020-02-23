package ru.bogdanov.guselnik.viewModel

import androidx.lifecycle.ViewModel
import ru.bogdanov.guselnik.item.Ingredient

class PlayPresenter :ViewModel(){
    var chosenInstruments:Array<Ingredient>?=null
}