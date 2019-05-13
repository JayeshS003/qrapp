package com.example.projecttest1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_student.*

class StudentActivity : AppCompatActivity() {

    internal lateinit var registerattendance: Button
    internal lateinit var todayattendance: Button
    internal lateinit var studentattendance: Button
    internal lateinit var btnLogout: Button
    private lateinit var toolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        //getting the toolbar
        // Set the toolbar as support action bar
        toolbar = findViewById(R.id.my_toolbar) as Toolbar
        setSupportActionBar(toolbar)

        // Now get the support action bar
        val actionBar = supportActionBar

        // Set toolbar title/app title
        actionBar!!.title = "Qr Attendence"

        // Initialize the action bar drawer toggle instance
        val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this,
            drawer_layout,
            toolbar,
            R.string.app_name,
            R.string.app_name
        ) {
            override fun onDrawerClosed(view: View) {
                super.onDrawerClosed(view)
                toast("Drawer closed")
            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                toast("Drawer Opened")
            }
        }

        // Configure the drawer layout to add listener and show icon on toolbar
        drawerToggle.isDrawerIndicatorEnabled = true
        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        // Set navigation view navigation item selected listener
        navigation.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.register_attendence -> {
                    Toast.makeText(this@StudentActivity, "Inside Register Student", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, RegisterAttendanceActivity::class.java)
                    startActivity(intent)
                }
                R.id.daily_attendence -> {
                    Toast.makeText(this@StudentActivity, "Inside Today's Attendence", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, TodayAttendanceActivity::class.java)
                    startActivity(intent)
                }
                R.id.monthly_attendence -> {
                    Toast.makeText(this@StudentActivity, "Inside monthly Attendence", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, StudentAttendanceActivity::class.java)
                    startActivity(intent)
                }

                R.id.logout -> {
                    Toast.makeText(this@StudentActivity, "Inside logout", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                }
            }
            // Close the drawer
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }
        // Close the drawer
        drawer_layout.closeDrawer(GravityCompat.START)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu to use in the action bar
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.menuScan -> {
                Toast.makeText(this@StudentActivity, "You Clicked Scan", Toast.LENGTH_LONG).show()
                val intent = Intent(this, QrCodeScannerActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.menuLogout -> {
                Toast.makeText(this, "You Clicked Logout", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.menuAbout -> {
                Toast.makeText(this, "You Clicked about", Toast.LENGTH_LONG).show()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    // Extension function to show toast message easily
    private fun Context.toast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

}
