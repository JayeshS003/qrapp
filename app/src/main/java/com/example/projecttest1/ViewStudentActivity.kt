package com.example.projecttest1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class ViewStudentActivity : AppCompatActivity() {
    internal lateinit var backbtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewstudent)
        backbtn = findViewById<View>(R.id.back) as Button

        // back to admin panel
        backbtn.setOnClickListener {
            // TODO Auto-generated method stub
            val intent = Intent(this, AdminActivity::class.java)
            startActivity(intent)
        }
    }
}
