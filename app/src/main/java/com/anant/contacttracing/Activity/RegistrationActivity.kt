package com.anant.contacttracing.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.anant.contacttracing.Database.DatabaseHelper
import com.anant.contacttracing.R

class RegistrationActivity : AppCompatActivity() {


    lateinit var handler: DatabaseHelper
    lateinit var btnSave: Button
    lateinit var etUserName:EditText
    lateinit var etEmail:EditText
    lateinit var etPassword:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        btnSave=findViewById(R.id.btnSave)
        etUserName=findViewById(R.id.etUserName)
        etEmail=findViewById(R.id.etEmail)
        etPassword=findViewById(R.id.etPassword)



        handler= DatabaseHelper(this)
        btnSave.setOnClickListener {
            handler.insertUserData(
                etUserName.text.toString(),
                etEmail.text.toString(),
                etPassword.text.toString()
            )
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }



    }
}
