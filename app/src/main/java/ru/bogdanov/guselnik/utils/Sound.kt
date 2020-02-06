package ru.bogdanov.guselnik.utils

import android.content.Context
import android.media.AudioAttributes
import android.media.SoundPool
import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Sound @Inject constructor(val context: Context) {
    private val TAG="sound_tag"
    private var soundPool:SoundPool? = null
    private var listener:SoundListener?=null
    private val streamsMap= mutableMapOf<Int,Int>()

    fun setSoundListener(soundListener: SoundListener){
        listener=soundListener
    }

    fun load(ids: Array<Int?>) {
        listener?.preparing()
        val audios = arrayOf<Int?>(null, null,null,null)
        var loadCount = ids.count { it!=null }
        if (soundPool==null) initializeSoundPool()
        soundPool?.setOnLoadCompleteListener { soundPool, sampleId, status ->
            if (status == 0) {
                loadCount--
            }
            if (loadCount == 0)
                startAll(audios)
        }
        ids.forEachIndexed { index, id ->
            if (id!=null){
                val id = soundPool?.load(context, id, 1)
                audios.set(index, id)
            }
        }
    }

    private fun initializeSoundPool() {
        soundPool=SoundPool.Builder()
            .setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            .setMaxStreams(4)
            .build()
    }

    private fun startAll(audios: Array<Int?>) {
        Log.d(TAG, "startAll: ${audios.joinToString()}")
        audios.forEach {
            if (it!=null&&soundPool!=null)
            streamsMap.put(it, soundPool!!.play(it, 1f, 1f, 1, -1, 1f))
        }
        listener?.ready()
    }

    fun setVolume(resource:Int, volume:Float){
        Log.d(TAG, "setVolume: $resource $volume ${streamsMap.contains(resource)}")
        val streamId=streamsMap.get(resource+1)
        if (streamId!=null)
        soundPool?.setVolume(streamId, volume, volume)
    }


    fun release() {
        soundPool?.release()
        soundPool=null
    }

    interface SoundListener{
        fun preparing()
        fun ready()
    }

}