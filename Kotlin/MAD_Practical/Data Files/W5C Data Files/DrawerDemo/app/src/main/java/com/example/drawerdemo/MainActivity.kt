package com.example.drawerdemo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MenuCompat
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.example.drawerdemo.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val nav by lazy { supportFragmentManager.findFragmentById(R.id.host)!!.findNavController() }

    // TODO: AppBarConfiguration


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO: AppBarConfiguration


        // TODO: Setup action bar and navigation view
        setupActionBarWithNavController(nav)


        // TODO: Custom action


        // TODO: Access to navigation view's header


    }

    override fun onSupportNavigateUp(): Boolean {
        // TODO
        return nav.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // NOTE: If SDK >= 28 -> menu?.setGroupDividerEnabled(true)
        MenuCompat.setGroupDividerEnabled(menu, true)
        menuInflater.inflate(R.menu.main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.groupId != R.id.main) return false // Pass control to next level (fragment)

        // Custom action
        when (item.itemId) {
            R.id.custom -> {
                Snackbar.make(binding.root, "Hello from Activity", Snackbar.LENGTH_SHORT).show()
                // TODO
            }
        }

        return item.onNavDestinationSelected(nav) || super.onOptionsItemSelected(item)
    }

}