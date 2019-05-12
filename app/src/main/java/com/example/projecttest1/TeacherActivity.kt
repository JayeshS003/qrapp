package com.example.projecttest1

import android.app.DatePickerDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_teacher.*
import java.util.*

class TeacherActivity : AppCompatActivity() {

    internal lateinit var takeattendance: Button
    internal lateinit var todayattendance: Button
    internal lateinit var viewattendance: Button
    internal lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacher)

        takeattendance = findViewById<View>(R.id.take_attendance) as Button
        todayattendance = findViewById<View>(R.id.today_attendance) as Button
        viewattendance = findViewById<View>(R.id.view_attendance) as Button
        btnLogout = findViewById<View>(R.id.btnLogout) as Button

        //button click to show datepicker
        pickDateBtn.setOnClickListener{
            val now = Calendar.getInstance()
            val datePicker = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                dateTv.setText(""+ dayOfMonth +"/"+ month +"/" +year)
            },
            now.get(Calendar.YEAR),now.get(Calendar.MONTH),now.get(Calendar.DAY_OF_MONTH))
            datePicker.show()
        }
        //calendar finish

        // take attendance button
        takeattendance.setOnClickListener {
            // TODO Auto-generated method stub
            val intent = Intent(this, TakeAttendanceActivity::class.java)
            startActivity(intent)
        }

        // today's attendance button
        todayattendance.setOnClickListener {
            // TODO Auto-generated method stub
            val intent = Intent(this, TodayAttendanceActivity::class.java)
            startActivity(intent)
        }

        // view attendance button
        viewattendance.setOnClickListener {
            // TODO Auto-generated method stub
            val intent = Intent(this, ViewAttendanceActivity::class.java)
            startActivity(intent)
        }

        // logout button
        btnLogout.setOnClickListener {
            // TODO Auto-generated method stub
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}
