package com.example.listviewdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import com.example.listviewdemo.databinding.ActivitySubBinding
import com.example.listviewdemo.util.DB
import com.example.listviewdemo.util.Fruit

class SubViewModel : ViewModel() {
    var fruit: Fruit? = null
    fun load(id: Int){ fruit = DB.get(id) }
    fun delete() = DB.delete((fruit?.id) ?: 0)
}

class SubActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySubBinding
    private val vm: SubViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vm = vm
        binding.lifecycleOwner = this

        // TODO
        /*
        val id = intent.getIntExtra("id", 0)
        val name = intent.getStringExtra("name")
        val icon = intent.getIntExtra("icon", 0)
        binding.txtId.text = "$id"
        title = "$id - $name"
        */

        val id = intent.getIntExtra("id", 0)
        vm.load(id)
        if(vm.fruit == null){
            finish()
            return
        }
        title = "${vm.fruit?.id} - ${vm.fruit?.name}"

        // TODO: btnClose
        binding.btnClose.setOnClickListener { finish() }

        // TODO: btnDelete
        binding.btnDelete.setOnClickListener { vm.delete(); finish() }
    }
}