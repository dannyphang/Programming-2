package com.example.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.databinding.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainViewModel : ViewModel(){
    var fname = MutableLiveData("")
    var lname = MutableLiveData("")
    val name = MediatorLiveData<String>()
//        get() = "${fname.value} ${lname.value}".trim().uppercase()
    init {
        name.addSource(fname) {
            "${fname.value} ${lname.value}".trim().uppercase()
        }
        name.addSource(lname) {
            "${fname.value} ${lname.value}".trim().uppercase()
        }
    }

    fun reset() {
        fname.value = ""
        lname.value = ""
    }
}


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
//    private val vm: MainViewModel by lazy { ViewModelProvider(this).get(MainViewModel::class.java) }
    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.vm = vm
        binding.lifecycleOwner = this


        /*
        binding.edtFname.doOnTextChanged { text, _, _, _ ->
            vm.fname = text.toString()
            binding.txtFcount.text = "${vm.fname.length}"
            binding.txtName.text = vm.name
            binding.btnSubmit.isEnabled = vm.name.isNotEmpty()
        }

        binding.edtLname.doOnTextChanged { text, _, _, _ ->
            vm.lname = text.toString()
            binding.txtLcount.text = "${vm.lname.length}"
            binding.txtName.text = vm.name
            binding.btnSubmit.isEnabled = vm.name.isNotEmpty()
        }
         */

        binding.btnSubmit.setOnClickListener {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(it.windowToken, 0)
            Snackbar.make(it, "Hello, ${vm.name.value}.", Snackbar.LENGTH_SHORT).show()
        }

        binding.btnReset.setOnClickListener {
//            binding.edtFname.text.clear()
//            binding.edtLname.text.clear()
            vm.reset()
            binding.edtFname.requestFocus()
        }
    }
}