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
    private lateinit var abc: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // TODO: AppBarConfiguration
        abc = AppBarConfiguration(
            setOf(R.id.homeFragment, R.id.page1Fragment, R.id.page2Fragment, R.id.page3Fragment),
            binding.drawerLayout
        )

        // TODO: Setup action bar and navigation view
        setupActionBarWithNavController(nav, abc) // to show the hamburger menu
        binding.navView.setupWithNavController(nav)

        // TODO: Custom action
        binding.navView.menu.findItem(R.id.custom).setOnMenuItemClickListener {
            Snackbar.make(binding.root, "Hello from Activity", Snackbar.LENGTH_SHORT).show()
            binding.drawerLayout.close()
            true
        }

        // TODO: Access to navigation view's header
        val header = binding.navView.getHeaderView(0)
        header.findViewById<ImageView>(R.id.photo).setImageResource(R.drawable.jieun)
        header.findViewById<TextView>(R.id.name).text = "LEE JI-EUN"
        header.findViewById<TextView>(R.id.email).text = "jieun@gmail.com"
    }

    override fun onSupportNavigateUp(): Boolean {
        // TODO
        return nav.navigateUp(abc) || super.onSupportNavigateUp()
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
                return true // after clicking the custom, it will stop from group main, if not it will show the second Snackbar immediately
            }
        }

        return item.onNavDestinationSelected(nav) || super.onOptionsItemSelected(item)
    }

}