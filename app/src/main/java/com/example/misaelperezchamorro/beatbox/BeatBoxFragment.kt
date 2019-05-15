package com.example.misaelperezchamorro.beatbox

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.misaelperezchamorro.beatbox.databinding.FragmentBeatBoxBinding
import com.example.misaelperezchamorro.beatbox.databinding.ListItemSoundBinding
import android.support.v7.widget.GridLayoutManager




class BeatBoxFragment: Fragment() {

    private var mBeatBox: BeatBox? = null

    companion object Factory {
        fun newInstance(): BeatBoxFragment = BeatBoxFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBeatBox = BeatBox(activity!!)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentBeatBoxBinding>(inflater, R.layout.fragment_beat_box, container, false)
        binding.recyclerView.layoutManager = GridLayoutManager(activity, 3)
        binding.recyclerView.adapter = SoundAdapter(mBeatBox!!.getSounds())
        return binding.root
    }

    private inner class SoundHolder internal constructor(private val mBinding: ListItemSoundBinding) : RecyclerView.ViewHolder(mBinding.root) {
        init {
            mBinding.viewModel = SoundViewModel(mBeatBox!!)
        }

        fun bind(sound: Sound) {
            mBinding.viewModel!!.sound = sound
            mBinding.executePendingBindings()
        }
    }

    //private inner class SoundHolder internal constructor(private val mBinding: ListItemSoundBinding) : RecyclerView.ViewHolder(mBinding.root)

    private inner class SoundAdapter(sounds: List<Sound>) : RecyclerView.Adapter<SoundHolder>() {

        private var mSounds: List<Sound>? = null

        init {
            this.mSounds = sounds
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundHolder {
            val inflater = LayoutInflater.from(activity)
            val binding = DataBindingUtil
                    .inflate<ListItemSoundBinding>(inflater, R.layout.list_item_sound, parent, false)
            return SoundHolder(binding)
        }

        override fun onBindViewHolder(holder: SoundHolder, position: Int) {
            val sound = mSounds!![position]
            holder.bind(sound)
        }
        override fun getItemCount(): Int {
             return mSounds!!.size
        }
    }

    //private class SoundAdapter: RecyclerView.Adapter<>
}