package com.example.diceroller

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.HtmlCompat
import com.example.diceroller.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPhone.setOnClickListener { openPhone("tel:+60165930959") }
        binding.btnSms.setOnClickListener { openSms("sms: +60165930959") }
        binding.btnWeb.setOnClickListener { openWeb("https://www.tarc.edu.my") }
        binding.btnMap.setOnClickListener { openMap("geo: 0, 0?q=3.216408932232403, 101.72895203922712") }

        binding.btnClose.setOnClickListener{ finish() }

        val html = assets.open("about.html").reader().readText()

        binding.txtAbout.text = HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }

    private fun openPhone(uri: String){
        val intent = Intent(Intent.ACTION_CALL, Uri.parse(uri))
        startActivity(intent)
    }

    private fun openSms(uri: String){
        val intent = Intent(Intent.ACTION_SENDTO, Uri.parse(uri))
        startActivity(intent)
    }

    private fun openWeb(uri: String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        startActivity(intent)
    }

    private fun openMap(uri: String){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri))
        startActivity(intent)
    }
}