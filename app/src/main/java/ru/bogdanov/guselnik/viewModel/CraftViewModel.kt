package ru.bogdanov.guselnik.viewModel

import android.view.View
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.bogdanov.guselnik.App
import ru.bogdanov.guselnik.craftUtils.*
import ru.bogdanov.guselnik.item.CraftDraft
import ru.bogdanov.guselnik.item.Ingredient
import javax.inject.Inject

class CraftViewModel : ViewModel() {
    val viewToRemove = MutableLiveData<View>()
    val viewToCreate = MutableLiveData<CraftDraft>()
    val newInstrument = MutableLiveData<Ingredient>()
    @Inject lateinit var musicInstruments: MusicInstruments

    init {
        App.appComponent.inject(this)
    }

    private val combiner = CraftItemCombiner(Recipe())

    fun collisionDetected(dropped: View, catcher: View) {
            combiner.combine(dropped, catcher){ draft, arrayToDelete ->
                arrayToDelete?.forEach { viewToRemove.value=it }
                if (draft!=null) {
                    viewToCreate.value=draft
                    if (draft.ingredient.isInstrument) {
                        val isNew=musicInstruments.saveOpenedInstrument(draft.ingredient.type)
                        if (isNew)
                        newInstrument.value=draft.ingredient
                    }
                }
            }
    }
}