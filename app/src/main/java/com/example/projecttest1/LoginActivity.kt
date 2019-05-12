package com.example.projecttest1

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.*

class LoginActivity : AppCompatActivity() {

    internal lateinit var spinner: Spinner
    internal lateinit var username: EditText
    internal lateinit var password: EditText
    internal lateinit var btnLogin: Button
    internal lateinit var userrole: String
    private val userRoleString = arrayOf("ADMIN", "TEACHER", "STUDENT")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        spinner = findViewById<View>(R.id.sp_option) as Spinner
        btnLogin = findViewById<View>(R.id.btnLogin) as Button
        username = findViewById<View>(R.id.username) as EditText
        password = findViewById<View>(R.id.password) as EditText

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                arg0: AdapterView<*>, view: View,
                arg2: Int, arg3: Long
            ) {

                (arg0.getChildAt(0) as TextView).setTextColor(Color.WHITE)
                userrole = spinner.selectedItem as String

            }

            override fun onNothingSelected(arg0: AdapterView<*>) {

            }
        }
        val adapter_role = ArrayAdapter(this, android.R.layout.simple_spinner_item, userRoleString)
        adapter_role.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter_role

        btnLogin.setOnClickListener {
            // TODO Auto-generated method stub
            System.out.println("****************************************************" + userrole);
            //admin login
            if (userrole == "ADMIN") {

                val user_name = username.text.toString()
                val pass_word = password.text.toString()

                if (TextUtils.isEmpty(user_name)) {
                    username.error = "Invalid User Name"
                } else if (TextUtils.isEmpty(pass_word)) {
                    password.error = "enter password"
                } else {
                    if ((user_name == "admin") and (pass_word == "admin123")) {
                        val intent = Intent(this, AdminActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(applicationContext, "Login successful", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(applicationContext, "Login failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            //teacher login
            if (userrole == "TEACHER") {

                val user_name = username.text.toString()
                val pass_word = password.text.toString()

                if (TextUtils.isEmpty(user_name)) {
                    username.error = "Invalid User Name"
                } else if (TextUtils.isEmpty(pass_word)) {
                    password.error = "enter password"
                } else {
                    if ((user_name == "teacher") and (pass_word == "teacher123")) {
                        val intent = Intent(this, TeacherActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(applicationContext, "Login successful", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(applicationContext, "Login failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            //student login
            if (userrole == "STUDENT") {

                val user_name = username.text.toString()
                val pass_word = password.text.toString()

                if (TextUtils.isEmpty(user_name)) {
                    username.error = "Invalid User Name"
                } else if (TextUtils.isEmpty(pass_word)) {
                    password.error = "enter password"
                } else {
                    if ((user_name == "student") and (pass_word == "student123")) {
                        val intent = Intent(this, StudentActivity::class.java)
                        startActivity(intent)
                        Toast.makeText(applicationContext, "Login successful", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(applicationContext, "Login failed", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            //login completed
        }
    }
}