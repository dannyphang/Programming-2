package com.example.logindemo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.logindemo.data.AuthViewModel
import com.example.logindemo.data.User
import com.example.logindemo.databinding.ActivityMainBinding
import com.example.logindemo.util.toBitmap

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val nav by lazy { supportFragmentManager.findFragmentById(R.id.host)!!.findNavController() }
    private val auth: AuthViewModel by viewModels()

    // AppBarConfiguration
    private lateinit var abc: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // AppBarConfiguration
        abc = AppBarConfiguration(
            setOf(
                // Top-level pages
                R.id.homeFragment,
                R.id.page1Fragment,
                R.id.page2Fragment,
                R.id.page3Fragment,
                R.id.page4Fragment,
            ),
            binding.drawerLayout
        )

        // Setup action bar and navigation view
        setupActionBarWithNavController(nav, abc)
        binding.navView.setupWithNavController(nav)

        // -----------------------------------------------------------------------------------------

        // TODO(5): Observe login status -> userLiveData
        auth.getUserLiveData().observe(this) { user ->
            // TODO(5A): Clear menu + remove header


            // TODO(5B): Inflate menu + header (based on login status)


            // TODO(5C): Handle logout menu item


        }

        // TODO(8): Auto login -> auth.loginFromPreferences(...)


    }

    private fun setHeader(user: User) {
        val h = binding.navView.getHeaderView(0)

        val imgPhoto: ImageView = h.findViewById(R.id.imgPhoto)
        val txtName : TextView  = h.findViewById(R.id.txtName)
        val txtEmail: TextView  = h.findViewById(R.id.txtEmail)

        imgPhoto.setImageBitmap(user.photo?.toBitmap())
        txtName.text  = user.name
        txtEmail.text = user.email
    }

    private fun logout(): Boolean {
        // TODO(4): Logout -> auth.logout(...)
        //          Clear navigation backstack


        binding.drawerLayout.close()
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return nav.navigateUp(abc) || super.onSupportNavigateUp()
    }

}