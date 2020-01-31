package ru.bogdanov.guselnik.utils

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Sound @Inject constructor(val context: Context) {
    private val soundPool=SoundPool.Builder()
        .setAudioAttributes(AudioAttributes.Builder()
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .build())
        .setMaxStreams(4)
        .build()
    private val streams= mutableListOf<Int>()

    fun load(ids:Array<Int>){
        val audios= mutableListOf<Int>()
        var loadCount=0
        soundPool.setOnLoadCompleteListener { soundPool, sampleId, status ->
            if (status==0){
                loadCount++
                if (loadCount==ids.size)
                    startAll(audios)
            }
        }
        ids.forEach {
            val id=soundPool.load(context, it, 1)
            audios.add(id)
        }
    }

    private fun startAll(audios: MutableList<Int>) {
        audios.forEach {
            streams.add(soundPool.play(it, 0f,0f,1,-1,1f))
        }
    }

    fun mute(index:Int){
        if (index<streams.size) {
            val streamId=streams[index]
            soundPool.setVolume(streamId,0f,0f)
        }
    }

    fun unmute(index:Int){
        if (index<streams.size) {
            val streamId=streams[index]
            soundPool.setVolume(streamId,1f,1f)
        }
    }

    fun release() {
        soundPool.release()
    }

}