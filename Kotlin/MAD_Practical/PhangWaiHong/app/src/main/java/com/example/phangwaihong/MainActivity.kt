package com.example.phangwaihong

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.phangwaihong.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var age = 0
    var salary = 0.0
    var overtime = 0.0
    var allowance = 0.0
    var income = 0.0
    var rate = 0.0
    var eeC = 0.0
    var eeR = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.edtAge.doOnTextChanged { text, start, end, count ->
            age = Integer.valueOf(text.toString())

        }
        binding.edtSalary.doOnTextChanged { text, start, end, count ->
            salary = text.toString().toDouble()

        }
        binding.edtOvertime.doOnTextChanged { text, start, end, count ->
            overtime = text.toString().toDouble()

        }
        binding.edtAllowance.doOnTextChanged { text, start, end, count ->
            allowance = text.toString().toDouble()

        }

        binding.submitBtn.setOnClickListener {
            if(age < 18){
                Toast.makeText(this, "Cannot less than 18", Toast.LENGTH_SHORT).show()
            }
            else if(salary < 0.01){
                Toast.makeText(this, "Cannot less than 0.01", Toast.LENGTH_SHORT).show()
            }
            else{
                income = age.toDouble() + salary + overtime + allowance
                rate = if (age < 60){
                    8.0
                } else{
                    4.8
                }
                eeC = income.toDouble() * (rate / 100.00)
                eeR = income.toDouble() * 0.12
                binding.textView15.setText("RM $income")
                binding.textView17.setText("$rate %")
                binding.textView18.setText("RM $eeC")
                binding.textView21.setText("RM $eeR")

            }

        }

        binding.resetBtn.setOnClickListener {
            binding.edtAge.text.clear()
            binding.edtSalary.text.clear()
            binding.edtOvertime.text.clear()
            binding.edtAllowance.text.clear()
            binding.edtAge.requestFocus()
        }

        binding.locateBtn.setOnClickListener {
            openMap("geo:3.208877, 101.742587")
        }
    }

    private fun openMap(uri: String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        startActivity(intent)
    }
}