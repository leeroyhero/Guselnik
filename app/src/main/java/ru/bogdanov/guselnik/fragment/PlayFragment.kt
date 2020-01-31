package ru.bogdanov.guselnik.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_play.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import ru.bogdanov.guselnik.App

import ru.bogdanov.guselnik.R
import ru.bogdanov.guselnik.adapter.OpenedInstrumentsAdapter
import ru.bogdanov.guselnik.craftUtils.MusicInstruments
import ru.bogdanov.guselnik.custom.PlayButton
import ru.bogdanov.guselnik.utils.Sound
import javax.inject.Inject


class PlayFragment : Fragment() {
    @Inject lateinit var sound: Sound
    @Inject lateinit var musicInstruments: MusicInstruments

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        App.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_play, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupOpenedInstruments()

        playButton1.setOnClickListener { showOpenedInstruments() }
        playButton2.setOnClickListener { hideOpenedInstruments() }
    }

    private fun setupOpenedInstruments() {
        recyclerOpenedInstruments.layoutManager=GridLayoutManager(context, 2, RecyclerView.HORIZONTAL, false)
        MainScope().launch {
            val arr=musicInstruments.getOpenedInstruments()
            if (arr!=null) recyclerOpenedInstruments.adapter=OpenedInstrumentsAdapter(arr)
        }
    }

    private fun showOpenedInstruments(){
        chooseInstrumentLayout.animate()
            .withStartAction {
                chooseInstrumentLayout.alpha=0f
                chooseInstrumentLayout.visibility=View.VISIBLE
                chooseInstrumentLayout.translationY=200f
            }
            .setInterpolator(DecelerateInterpolator())
            .alpha(1f)
            .translationY(0f)
            .setDuration(200L)
            .start()
    }

    private fun hideOpenedInstruments(){
        chooseInstrumentLayout.animate()
            .withEndAction {
                chooseInstrumentLayout.visibility=View.INVISIBLE
            }
            .setInterpolator(AccelerateInterpolator())
            .alpha(0f)
            .translationY(200f)
            .setDuration(200L)
            .start()
    }


    override fun onStop() {
        sound?.release()
        super.onStop()
    }


}
