package ru.bogdanov.guselnik.custom

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.music_player.view.*
import ru.bogdanov.guselnik.R
import ru.bogdanov.guselnik.item.Ingredient

class MusicPlayer @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private var listener: MusicPlayerListener? = null

    init {
        inflate(context, R.layout.music_player, this)
    }

    fun setList(array:Array<Ingredient>){
        val instrButtonArray = arrayOf(
            instrumentButton0, instrumentButton1, instrumentButton2, instrumentButton3, instrumentButton4
        )
        instrButtonArray.forEachIndexed { index, playButton ->
            val ingr=array.getOrNull(index)
            if (ingr!=null){
                playButton.volumeListener {
                    if (playButton.getIngredient()?.sound != null)
                        listener?.volumeChanged(index, it)
                }
                playButton.setInstrument(ingr)
                playButton.visibility=View.VISIBLE
            } else playButton.visibility=View.GONE
        }
    }

    fun setListener(musicListener: MusicPlayerListener) {
        listener = musicListener
    }

    interface MusicPlayerListener {
        fun volumeChanged(index: Int, volume: Float)
    }
}