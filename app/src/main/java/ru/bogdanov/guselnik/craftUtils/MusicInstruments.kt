package ru.bogdanov.guselnik.craftUtils

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ru.bogdanov.guselnik.item.Ingredient
import ru.bogdanov.guselnik.item.getIngredientByType
import javax.inject.Inject

class MusicInstruments @Inject constructor(val context: Context) {
    private val prefs = context.getSharedPreferences("opened_instruments", Context.MODE_PRIVATE)

    suspend fun getOpenedInstruments(): Array<Ingredient> = withContext(Dispatchers.IO) {
        val map = prefs.all
        val sortedList = map.entries.sortedByDescending { it.value as Long }
        sortedList.map { it.key }.map { getIngredientByType(it) }.filterNotNull()
            .filter { it.sound != null }.toTypedArray()
    }

    fun saveOpenedInstrument(type: String): Boolean {
        val isNew = !prefs.contains(type)
        prefs.edit().putLong(type, System.currentTimeMillis()).apply()
        return isNew
    }
}