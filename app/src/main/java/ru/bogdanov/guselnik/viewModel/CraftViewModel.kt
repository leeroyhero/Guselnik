package ru.bogdanov.guselnik.viewModel

import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import ru.bogdanov.guselnik.custom.CraftView


class CraftViewModel: ViewModel() {
    fun collisionDetected(v: View, view: View) {
        val firstType=(v as CraftView).type
        val secondType=(view as CraftView).type

        Toast.makeText(v.context, "collision: $firstType $secondType", Toast.LENGTH_SHORT).show()
    }

}