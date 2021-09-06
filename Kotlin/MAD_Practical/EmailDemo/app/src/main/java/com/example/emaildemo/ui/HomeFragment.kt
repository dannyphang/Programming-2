package com.example.emaildemo.ui

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.emaildemo.databinding.FragmentHomeBinding
import com.example.emaildemo.util.SimpleEmail
import com.google.android.material.snackbar.Snackbar
import java.text.DecimalFormat

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val nav by lazy { findNavController() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.btnSend.setOnClickListener { send() }
        return binding.root
    }

    // TODO: Compose and send email
    private fun send() {
        hideKeyboard()

        val email = binding.edtEmail.text.toString().trim()
        if (!isEmail(email)){
            snackbar("Invalid email")
            binding.btnSend.requestFocus()
            return
        }

        val formatter = DecimalFormat("000000")
        val n = (0..999999).random()
        val number = formatter.format(n)

        val subject = "Lucky number - ${System.currentTimeMillis()}"
        val content = """
            <p>Your lucky number is:</p>
            <h1 style="color: red">$number</h1>
            <p>Thank you very much!</p>
        """.trimIndent()

        SimpleEmail()
            .to(email)
            .content(content)
            .isHtml()
            .send(){
                snackbar("Email sent~")
                binding.btnSend.isEnabled = true
                binding.btnSend.requestFocus()
            }
        snackbar("Sending...")
        binding.btnSend.isEnabled = false
    }

    // TODO: Validate if email address valid
    private fun isEmail(email: String) = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    private fun hideKeyboard() {
        val imm = requireContext().getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(requireView().windowToken, 0)
    }

    private fun snackbar(text: String) {
        Snackbar.make(requireView(), text, Snackbar.LENGTH_SHORT).show()
    }

}