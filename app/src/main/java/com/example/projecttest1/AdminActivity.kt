package com.example.projecttest1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class AdminActivity : AppCompatActivity() {

    internal lateinit var addstudent: Button
    internal lateinit var viewstudent: Button
    internal lateinit var viewattendance: Button
    internal lateinit var addcourse: Button
    internal lateinit var addsubject: Button
    internal lateinit var addteacher: Button
    internal lateinit var viewteacher: Button
    internal lateinit var btnLogout: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        addstudent = findViewById<View>(R.id.add_student) as Button
        viewstudent = findViewById<View>(R.id.view_student) as Button
        viewattendance = findViewById<View>(R.id.view_attendance) as Button
        addcourse = findViewById<View>(R.id.add_course) as Button
        addsubject = findViewById<View>(R.id.add_subject) as Button
        addteacher = findViewById<View>(R.id.add_teacher) as Button
        viewteacher = findViewById<View>(R.id.view_teacher) as Button
        btnLogout = findViewById<View>(R.id.btnLogout) as Button

        // add student button
        addstudent.setOnClickListener {
            // TODO Auto-generated method stub
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivity(intent)
        }

        // view student button
        viewstudent.setOnClickListener {
            // TODO Auto-generated method stub
            val intent = Intent(this, ViewStudentActivity::class.java)
            startActivity(intent)
        }

        // view attendance button
        viewattendance.setOnClickListener {
            // TODO Auto-generated method stub
            val intent = Intent(this, ViewAttendanceActivity::class.java)
            startActivity(intent)
        }

        // add course button
        addcourse.setOnClickListener {
            // TODO Auto-generated method stub
            val intent = Intent(this, AddCourseActivity::class.java)
            startActivity(intent)
        }

        // add subject button
        addsubject.setOnClickListener {
            // TODO Auto-generated method stub
            val intent = Intent(this, AddSubjectActivity::class.java)
            startActivity(intent)
        }

        // add teacher button
        addteacher.setOnClickListener {
            // TODO Auto-generated method stub
            val intent = Intent(this, AddTeacherActivity::class.java)
            startActivity(intent)
        }

        // view teacher button
        viewteacher.setOnClickListener {
            // TODO Auto-generated method stub
            val intent = Intent(this, ViewTeacherActivity::class.java)
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
