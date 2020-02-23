package ru.bogdanov.guselnik.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.widget.Button
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_play.*
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import ru.bogdanov.guselnik.App

import ru.bogdanov.guselnik.R
import ru.bogdanov.guselnik.adapter.OpenedInstrumentsAdapter
import ru.bogdanov.guselnik.craftUtils.MusicInstruments
import ru.bogdanov.guselnik.custom.MusicPlayer
import ru.bogdanov.guselnik.custom.PlayButton
import ru.bogdanov.guselnik.item.Ingredient
import ru.bogdanov.guselnik.utils.Sound
import ru.bogdanov.guselnik.viewModel.PlayPresenter
import javax.inject.Inject


class PlayFragment : Fragment() {
    @Inject
    lateinit var sound: Sound

    private val model:PlayPresenter by activityViewModels()


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

        buttonChangeInstruments.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_playFragment_to_chooseInstrumentFragment))
    }

    override fun onResume() {
        super.onResume()
        val chosenList=model.chosenInstruments
        if (chosenList.isNullOrEmpty()) showPlaceholder()
        else showMusicPlayer(chosenList)
    }

    private fun showMusicPlayer(chosenList: Array<Ingredient>) {
        sound.setSoundListener(object : Sound.SoundListener {
            override fun preparing() {
                progressBarPlayFragment.visibility=View.VISIBLE
            }

            override fun ready() {
                progressBarPlayFragment.visibility=View.INVISIBLE
            }
        })
        musicPlayer.setListener(object : MusicPlayer.MusicPlayerListener {
            override fun volumeChanged(index: Int, volume: Float) {
               sound.setVolume(index, volume)
            }
        })
        musicPlayer.setList(chosenList)
        sound.load(chosenList.map { it.sound }.toTypedArray())
        musicPlayer.visibility=View.VISIBLE
    }

    private fun showPlaceholder() {
        musicPlayer.visibility=View.GONE
    }

    override fun onPause() {
        super.onPause()
        sound.release()
    }


}
