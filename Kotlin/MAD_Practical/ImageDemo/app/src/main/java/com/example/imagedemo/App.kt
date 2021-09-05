package com.example.imagedemo

import android.app.Application
import com.example.imagedemo.data.DB

class App : Application() {

    companion object {
        lateinit var db: DB
    }

    override fun onCreate() {
        super.onCreate()
        db = DB.getInstance(this)
    }

}