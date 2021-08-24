package com.example.roomdemo1

import android.app.Application
import com.example.roomdemo1.data.DB
import com.example.roomdemo1.data.Fruit
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class App: Application() {

    companion object {
        lateinit var db: DB

    }

    override fun onCreate() {
        super.onCreate()
        db = DB.getInstance(this)

//        GlobalScope.launch {
//            db.fruitDao.insert(Fruit(1, "Apple", 1.00))
//            db.fruitDao.insert(Fruit(2, "Banana", 2.00))
//            db.fruitDao.insert(Fruit(3, "Orange", 3.00))
//            db.fruitDao.insert(Fruit(4, "Watermelon", 4.00))
//            db.fruitDao.insert(Fruit(5, "Cheery", 5.00))
//            db.fruitDao.insert(Fruit(6, "Pineapple", 6.00))
//        }

    }
}