package com.example.roomdemo2

import android.app.Application
import com.example.roomdemo2.data.DB

class App : Application() {

    companion object {
        lateinit var db: DB
    }

    override fun onCreate() {
        super.onCreate()
        db = DB.getInstance(this)
    }

}