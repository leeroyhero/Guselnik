package ru.bogdanov.guselnik.viewModel

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.bogdanov.guselnik.App
import ru.bogdanov.guselnik.craftUtils.*
import ru.bogdanov.guselnik.fragment.CraftFragment
import ru.bogdanov.guselnik.interfaces.CraftListener
import ru.bogdanov.guselnik.item.CraftDraft
import ru.bogdanov.guselnik.item.Ingredient
import javax.inject.Inject

class CraftViewModel : ViewModel() {

    private var craftListener:CraftListener?=null
    @Inject lateinit var musicInstruments: MusicInstruments

    init {
        App.appComponent.inject(this)
    }

    fun setCraftListener(listener: CraftListener){
        craftListener=listener
    }

    private val combiner = CraftItemCombiner(Recipe())

    fun collisionDetected(dropped: View, catcher: View) {
            combiner.combine(dropped, catcher){ draft, arrayToDelete ->
                arrayToDelete?.forEach { craftListener?.removeView(it) }
                if (draft!=null) {
                    craftListener?.createView(draft)
                    if (draft.ingredient.isInstrument) {
                        val isNew=musicInstruments.saveOpenedInstrument(draft.ingredient.type)
                        if (isNew)
                            craftListener?.newInstrumentOpened(draft.ingredient)
                    }
                }
            }
    }
}