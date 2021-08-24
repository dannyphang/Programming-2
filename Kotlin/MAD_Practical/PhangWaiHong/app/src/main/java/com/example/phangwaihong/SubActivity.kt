package com.example.phangwaihong

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.phangwaihong.ui.main.SubFragment

class SubActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sub_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, SubFragment.newInstance())
                .commitNow()
        }
    }
}