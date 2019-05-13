package com.example.projecttest1

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_student.*
import kotlinx.android.synthetic.main.activity_teacher.*
import kotlinx.android.synthetic.main.activity_teacher.drawer_layout
import java.util.*

class TeacherActivity : AppCompatActivity() {

    internal lateinit var takeattendance: Button
    internal lateinit var todayattendance: Button
    internal lateinit var viewattendance: Button
    internal lateinit var btnLogout: Button
    private lateinit var toolbar: Toolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)

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
        navigation_teacher.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.register_attendence -> {
                    Toast.makeText(this@TeacherActivity, "Inside Take Student", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, TakeAttendanceActivity::class.java)
                    startActivity(intent)
                }
                R.id.daily_attendence -> {
                    Toast.makeText(this@TeacherActivity, "Inside Today's Attendence", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, TodayAttendanceActivity::class.java)
                    startActivity(intent)
                }
                R.id.monthly_attendence -> {
                    Toast.makeText(this@TeacherActivity, "Inside view Attendence", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, ViewAttendanceActivity::class.java)
                    startActivity(intent)
                }

                R.id.logout -> {
                    Toast.makeText(this@TeacherActivity, "Inside logout", Toast.LENGTH_LONG).show()
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
        inflater.inflate(R.menu.teacher_menu_action_bar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.GenerateBarCode -> {
                Toast.makeText(this@TeacherActivity, "Generate Barcode", Toast.LENGTH_LONG).show()
                displaySingleSelectionDialog();
//                val intent = Intent(this, GenerateBarCode::class.java)
//                startActivity(intent)
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

    /*
   display dialog to select single option
    */
    private var checkedItem = -1
    private var androidVersions: Array<String>? = null

    private fun displaySingleSelectionDialog() {
        androidVersions = arrayOf("ADMIN", "TEACHER", "STUDENT")
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder.setTitle("Which Subject to Scan")
        dialogBuilder.setSingleChoiceItems(
            androidVersions, checkedItem
        ) { dialogInterface, which -> checkedItem = which }
        dialogBuilder.setPositiveButton("Done") { dialog, which ->
            showSelectedVersion()


        }
        dialogBuilder.create().show()
    }

    // Extension function to show toast message easily
    private fun Context.toast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    private fun showSelectedVersion() {
        //  val nullable: Int? = checkedItem
        val checkedVal = androidVersions?.getOrNull(checkedItem)
        if (checkedVal == null) {
            Toast.makeText(this, "You selected: Nothing", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "You selected: " + androidVersions?.getOrNull(checkedItem), Toast.LENGTH_SHORT).show()
            //once teacher has selected option from the alertbox show barcode based on those information
            val intent = Intent(this, GenerateBarCode::class.java)
            startActivity(intent)
        }
    }

}