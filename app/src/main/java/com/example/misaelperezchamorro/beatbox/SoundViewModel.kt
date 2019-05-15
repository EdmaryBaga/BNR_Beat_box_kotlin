package com.example.misaelperezchamorro.beatbox

import android.databinding.BaseObservable
import android.databinding.Bindable


class SoundViewModel(private val mBeatBox: BeatBox) : BaseObservable() {
    var sound: Sound? = null
        set(sound) {
            field = sound
            notifyChange()
        }
    val title: String
        @Bindable
        get() = sound!!.name
}