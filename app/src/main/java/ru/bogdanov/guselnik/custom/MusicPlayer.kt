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
    private val view: View
    private var isPlaying = false
    private val instrButtonArray: Array<PlayButton>

    init {
        view = inflate(context, R.layout.music_player, this)
        buttonPlay.setOnClickListener { buttonPlayClicked() }

        instrButtonArray = arrayOf(
            instrumentButton0, instrumentButton1, instrumentButton2, instrumentButton3
        )
        instrButtonArray.forEachIndexed { index, playButton ->
            playButton.setOnClickListener {
                instrumentButtonClicked(playButton, index)
            }
            playButton.volumeListener {
                if (playButton.getIngredient()?.sound != null)
                    listener?.volumeChanged(index, it)
            }
        }
    }

    private fun instrumentButtonClicked(instrumentButton: PlayButton, index: Int) {
        if (!isPlaying) {
            listener?.editInstrument(index, instrumentButton)
        }
    }

    private fun buttonPlayClicked() {
        when (isPlaying) {
            true -> {
                isPlaying = false
                listener?.pause()
                buttonPlay.text = "Играть"
            }
            false -> {
                isPlaying = true
                val audioArray = getAudioArray()
                listener?.play(audioArray)
                buttonPlay.text = "Изменить доску"
            }
        }
    }

    private fun getAudioArray(): Array<Int?> {
        return arrayOf(
            instrumentButton0.getIngredient()?.sound,
            instrumentButton1.getIngredient()?.sound,
            instrumentButton2.getIngredient()?.sound,
            instrumentButton3.getIngredient()?.sound
        )
    }

    fun setListener(musicListener: MusicPlayerListener) {
        listener = musicListener
    }

    interface MusicPlayerListener {
        fun pause()
        fun play(audios: Array<Int?>)
        fun editInstrument(index: Int, instrumentView: PlayButton)
        fun volumeChanged(index: Int, volume: Float)
    }
}