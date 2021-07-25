package com.example.spinner

import androidx.annotation.DrawableRes
import androidx.lifecycle.*

data class Student(
    var id: String,
    var name: String,
) {
    override fun toString() = name
}

data class Country (
    var id: String,
    var name: String,
    @DrawableRes var icon: Int,
)

class MainViewModel: ViewModel() {
    val students = listOf(
        Student("20XXX00001", "See Kwee Teck"),
        Student("20XXX00002", "Peh Guan Soon"),
        Student("20XXX00003", "Liaw Chun Voon"),
        Student("20XXX00004", "Fong Cheng Weng"),
        Student("20XXX00005", "Lam Yaw Seng"),
    )

    var studentIndex = MutableLiveData<Int>(0)
    val student = studentIndex.map { i -> students[i] }

    val countries = listOf(
        Country("MY", "Malaysia", R.drawable.malaysia),
        Country("SG", "Singapore", R.drawable.singapore),
        Country("TH", "Thailand", R.drawable.thailand),
        Country("BN", "Brunei", R.drawable.brunei),
        Country("ID", "Indonesia", R.drawable.indonesia),
    )

    var countryIndex = MutableLiveData<Int>(0)
    val country = countryIndex.map { i -> countries[i] }
}