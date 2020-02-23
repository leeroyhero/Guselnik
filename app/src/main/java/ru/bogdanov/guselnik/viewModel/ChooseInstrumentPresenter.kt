package ru.bogdanov.guselnik.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.bogdanov.guselnik.App
import ru.bogdanov.guselnik.craftUtils.MusicInstruments
import ru.bogdanov.guselnik.item.Ingredient
import javax.inject.Inject

class ChooseInstrumentPresenter : ViewModel() {
    @Inject
    lateinit var musicInstruments: MusicInstruments

    val instrumentListData = MutableLiveData<Array<Ingredient>>()

    init {
        App.appComponent.inject(this)
    }

    fun loadOpenedInstruments(){
        viewModelScope.launch {
            instrumentListData.value = musicInstruments.getOpenedInstruments()
        }
    }
}
