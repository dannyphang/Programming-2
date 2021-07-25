package com.example.landscape

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.landscape.databinding.ActivityMainBinding

class MainViewModel : ViewModel(){
    var count = MutableLiveData(0)

    fun increment() {
//        count.value = count.value!! + 1
        count.value = (count.value ?: 0) + 1 // if "count.value" is null, then will get 0, else will go for "count.value"
    }
}

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vm = vm
        binding.lifecycleOwner = this
    }
}