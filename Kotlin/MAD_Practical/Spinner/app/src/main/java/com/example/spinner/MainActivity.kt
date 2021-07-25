package com.example.spinner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import com.example.spinner.databinding.ActivityMainBinding
import com.example.spinner.util.SimpleArrayAdapter

// (1) Static
// (2) Dynamic
// (3) Data Binding
// (4) Custom

data class Fruit(
    var id : Int,
    var name: String,
){
    override fun toString() = "$id - $name"
}

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val vm: MainViewModel by viewModels()

//    private val fruits = mutableListOf(
//        "Apple",
//        "Banana",
//        "Watermelon",
//        "Strawberry",
//    )

    private val fruits = listOf(
        Fruit(1, "Apple"),
        Fruit(2, "Banana"),
        Fruit(3, "Orange"),
        Fruit(4, "Watermelon"),
        Fruit(5, "Strawberry"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vm = vm
        binding.lifecycleOwner = this

        // (1)
        binding.spn1.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                binding.txt1.text = binding.spn1.selectedItem as String
            }

            override fun onNothingSelected(parent: AdapterView<*>?) = Unit
        }

        // (2)
//        val adp2 = ArrayAdapter.createFromResource(this, R.array.states, android.R.layout.simple_spinner_dropdown_item)
////        adp2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        binding.spn2.adapter = adp2

        val adp2 = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, fruits)
        binding.spn2.adapter = adp2

        binding.spn2.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val f = binding.spn2.selectedItem as Fruit
                binding.txt2.text = f.name
            }

            override fun onNothingSelected(parent: AdapterView<*>?) = Unit
        }

        // (3)

        // (4)
        val adp4 = SimpleArrayAdapter(this, R.layout.spinner_country, vm.countries) {
            view, item, _, _ ->
                val img: ImageView = view.findViewById(R.id.img)
                val txt: TextView = view.findViewById(R.id.txt)
                img.setImageResource(item.icon)
                txt.text = item.name
        }
        binding.spn4.adapter = adp4
    }
}