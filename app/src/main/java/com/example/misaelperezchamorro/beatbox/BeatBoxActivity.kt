package com.example.misaelperezchamorro.beatbox

import android.support.v4.app.Fragment

class BeatBoxActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment {
        return BeatBoxFragment.newInstance() as Fragment
    }
}
