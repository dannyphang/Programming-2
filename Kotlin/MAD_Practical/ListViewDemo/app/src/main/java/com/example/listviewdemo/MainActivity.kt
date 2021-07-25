package com.example.listviewdemo

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.example.listviewdemo.databinding.ActivityMainBinding
import com.example.listviewdemo.util.DB
import com.example.listviewdemo.util.Fruit
import com.example.listviewdemo.util.SimpleArrayAdapter

class MainViewModel : ViewModel() {
    val fruits = DB.getAll()
    fun delete(id: Int) = DB.delete(id)
    fun random() = DB.random()
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

        // TODO

//        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, vm.fruits.value!!)

        val adapter = SimpleArrayAdapter(this, R.layout.list_item, vm.fruits.value!!){
            view, item, _, _ ->
                val img: ImageView = view.findViewById(R.id.img)
                val txt: TextView = view.findViewById(R.id.txt)
                val btn: Button = view.findViewById(R.id.btn)
                img.setImageResource(item.icon)
                txt.text = "${item.id} - ${item.name}"
                btn.setOnClickListener { vm.delete(item.id) }
        }

        vm.fruits.observe(this) { adapter.notifyDataSetChanged() }

        binding.lst.adapter = adapter

        binding.lst.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val item = parent.getItemAtPosition(position) as Fruit
//            Snackbar.make(parent, item.name, Snackbar.LENGTH_SHORT).show()
            val intent = Intent(this, SubActivity::class.java)
                .putExtra("id", item.id)
                .putExtra("name", item.name)
                .putExtra("icon", item.icon)
            startActivity(intent)
        }

    }
}