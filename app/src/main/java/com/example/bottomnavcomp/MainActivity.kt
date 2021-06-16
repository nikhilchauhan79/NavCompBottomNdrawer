package com.example.bottomnavcomp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*

class MainActivity : AppCompatActivity(),
    NavigationView.OnNavigationItemSelectedListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)
        toggle.isDrawerIndicatorEnabled=true
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()


    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.homeFragment -> {
                val fragment = HomeFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                    .commit()
                return true
            }
            R.id.notificationFragment -> {
                val fragment = NotificationFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                    .commit()
                return true
            }
            R.id.galleryFragment -> {
                val fragment = GalleryFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                    .commit()
                return true
            }

            R.id.profileFragment -> {
                val fragment = ProfileFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                    .commit()
                return true
            }

            R.id.settingsFragment -> {
                val fragment = SettingsFragment()
                supportFragmentManager.beginTransaction().replace(R.id.container, fragment, fragment.javaClass.getSimpleName())
                    .commit()
                return true
            }

            else -> return super.onOptionsItemSelected(item)

        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.bookmarkFragment -> {
                Toast.makeText(this, "Bookmark clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.movieFragment -> {
                Toast.makeText(this, "Movie Clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.musicFragment -> {
                Toast.makeText(this, "Music Clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.gameFragment -> {
                Toast.makeText(this, "Game Clicked", Toast.LENGTH_SHORT).show()
            }
            R.id.phoneFragment -> {
                Toast.makeText(this, "Phone Clicked", Toast.LENGTH_SHORT).show()
            }

            R.id.messageFragment -> {
                Toast.makeText(this, "Message Clicked", Toast.LENGTH_SHORT).show()
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}