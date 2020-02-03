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
    private var listener:MusicPlayerListener?=null
    private val view:View
    private var isPlaying=false
    init {
        view= inflate(context, R.layout.music_player, this)
        buttonPlay.setOnClickListener { buttonPlayClicked() }

        instrumentButton0.setOnClickListener { instrumentButtonClicked(instrumentButton0, 0) }
        instrumentButton1.setOnClickListener { instrumentButtonClicked(instrumentButton1, 1) }
        instrumentButton2.setOnClickListener { instrumentButtonClicked(instrumentButton2, 2) }
        instrumentButton3.setOnClickListener { instrumentButtonClicked(instrumentButton3, 3) }
    }

    private fun instrumentButtonClicked(instrumentButton: PlayButton, index: Int) {
        if (!isPlaying){
            listener?.editInstrument(index, instrumentButton)
        }
    }

    private fun buttonPlayClicked() {
        when(isPlaying){
            true->{
                isPlaying=false
                listener?.pause()
                buttonPlay.text="Играть"
            }
            false->{
                isPlaying=true
                val audioArray=getAudioArray()
                listener?.play(audioArray)
                buttonPlay.text="Изменить доску"
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

    fun setListener(musicListener:MusicPlayerListener){
        listener=musicListener
    }

    interface MusicPlayerListener{
        fun pause()
        fun play(audios:Array<Int?>)
        fun editInstrument(index:Int, instrumentView:PlayButton)
        fun volumeChanged(index:Int, volume:Float)
    }
}