package com.example.listviewdemo.util

import androidx.annotation.DrawableRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.listviewdemo.R

data class Fruit(
    var id: Int,
    var name: String,
    @DrawableRes var icon: Int,
){
    override fun toString() = name
}


// Singleton
object DB {
    private val data = mutableListOf(
        Fruit(1, "Avocado", R.drawable.avocado),
        Fruit(2, "Banana", R.drawable.banana),
        Fruit(3, "Blueberries", R.drawable.blueberries),
        Fruit(4, "Cherries", R.drawable.cherries),
        Fruit(5, "Coconut", R.drawable.coconut),
        Fruit(6, "Grapes", R.drawable.grapes),
        Fruit(7, "Green Apple", R.drawable.greenapple),
        Fruit(8, "Kiwi", R.drawable.kiwi),
        Fruit(9, "Lemon", R.drawable.lemon),
        Fruit(10, "Mango", R.drawable.mango),
        Fruit(11, "Melon", R.drawable.melon),
        Fruit(12, "Olive", R.drawable.olive),
        Fruit(13, "Orange", R.drawable.orange),
        Fruit(14, "Peach", R.drawable.peach),
        Fruit(15, "Pear", R.drawable.pear),
        Fruit(16, "Pineapple", R.drawable.pineapple),
        Fruit(17, "Pomegranate", R.drawable.pomegranate),
        Fruit(18, "Red Apple", R.drawable.redapple),
        Fruit(19, "Strawberry", R.drawable.strawberry),
        Fruit(20, "Tangerine", R.drawable.tangerine),
        Fruit(21, "Tomato", R.drawable.tomato),
        Fruit(22, "Watermelon", R.drawable.watermelon),
    )

    private val fruits = MutableLiveData(data)

    fun getAll(): LiveData<MutableList<Fruit>> = fruits

    fun get(id: Int) = data.find { f -> f.id == id }

    fun delete(id: Int) {
        val f = get(id)
        data.remove(f)
        fruits.value = data
    }

    fun random(){
        val f = data.randomOrNull()
        data.remove(f)
        fruits.value = data
    }
}