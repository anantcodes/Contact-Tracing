package com.anant.contacttracing.Activity


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.anant.contacttracing.Database.DatabaseHelper
import com.anant.contacttracing.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var txtForgotPassword: TextView
    lateinit var txtRegisterYourself: TextView
    lateinit var btnLogin:Button
    lateinit var handler: DatabaseHelper

    lateinit var sharedPreferences: SharedPreferences




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
        if (isLoggedIn) {
            val intent = Intent(this@LoginActivity, ControlActivity::class.java)
            startActivity(intent)
            finish()
        }

btnLogin=findViewById(R.id.btnLogin)

        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegisterYourself = findViewById(R.id.txtRegisterYourself)
        handler= DatabaseHelper(this)


     /*   /*Clicking on this text takes you to the forgot password activity*/
        txtForgotPassword.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ForgotPasswordActivity::class.java))
        }*/
//startActivity(intent)
        /*Clicking on this text takes you to the forgot password activity*/
        txtRegisterYourself.setOnClickListener {
            startActivity(Intent(this, RegistrationActivity::class.java))
        }
btnLogin.setOnClickListener {
   if( handler.userPresent(etEmail.text.toString(),etPassword.text.toString()))
   {
       savePreferences()
       val intent = Intent(this, ControlActivity::class.java)
       startActivity(intent)
   }
    else
   {
       Toast.makeText(this@LoginActivity, "not Success", Toast.LENGTH_SHORT)
           .show()
   }

}


    }


    fun savePreferences(){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
    }


}
