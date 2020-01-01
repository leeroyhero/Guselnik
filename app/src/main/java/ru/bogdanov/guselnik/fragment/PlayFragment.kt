package ru.bogdanov.guselnik.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_play.*

import ru.bogdanov.guselnik.R
import ru.bogdanov.guselnik.utils.Sound


class PlayFragment : Fragment() {
    private var sound: Sound? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_play, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        if (context != null) {
            sound = Sound(context!!)
            sound?.load(
                arrayOf(
                    R.raw.balalayka,
                    R.raw.doska,
                    R.raw.gusli1,
                    R.raw.kaluka,
                    R.raw.logki
                )
            )

            preparePlaying(button,0)
            preparePlaying(button2,1)
            preparePlaying(button3,2)
            preparePlaying(button4,3)
            preparePlaying(button5,4)
        }
    }

    private fun preparePlaying(button: Button, index: Int) {
        var muted = true
        button.setOnClickListener {
                if (muted) {
                    sound?.unmute(index)
                    muted = false
                } else {
                    sound?.mute(index)
                    muted = true
                }
        }
    }

    override fun onStop() {
        sound?.release()
        super.onStop()
    }


}
