package com.anant.contacttracing.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.anant.contacttracing.Fragment.PreviousFragment
import com.anant.contacttracing.R
import kotlinx.android.synthetic.main.activity_previous.*
import java.text.DateFormat
import java.util.*


class TodayActivity : AppCompatActivity() {

    lateinit var txtDate:TextView
    lateinit var txtName1:EditText
    lateinit var txtName2:EditText
    lateinit var txtName3:EditText
    lateinit var txtName4:EditText
    lateinit var txtName5:EditText
    lateinit var txtName6:EditText
    lateinit var txtName7:EditText
    lateinit var txtName8:EditText
    lateinit var txtName9:EditText
    lateinit var txtName10:EditText
    lateinit var btnAdd: Button
    lateinit var btnSave:Button

    private val sharedPrefFile = "kotlinsharedpreference"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_today)

        txtDate=findViewById(R.id.txtDate)
        txtName1=findViewById(R.id.txtName1)
        txtName2=findViewById(R.id.txtName2)
        txtName3=findViewById(R.id.txtName3)
        txtName4=findViewById(R.id.txtName4)
        txtName5=findViewById(R.id.txtName5)
        txtName6=findViewById(R.id.txtName6)
        txtName7=findViewById(R.id.txtName7)
        txtName8=findViewById(R.id.txtName8)
        txtName9=findViewById(R.id.txtName9)
        txtName10=findViewById(R.id.txtName10)
        btnAdd=findViewById(R.id.btnAdd)
        btnSave=findViewById(R.id.btnSave)


        val rightNow = Calendar.getInstance()
        val currentDate:String=DateFormat.getInstance().format(rightNow.time)
        txtDate.text = currentDate

        val sharedPreferences: SharedPreferences = this.getSharedPreferences(sharedPrefFile,
            Context.MODE_PRIVATE)

        txtName2.visibility = GONE
        txtName3.visibility = GONE
        txtName4.visibility = GONE
        txtName5.visibility = GONE
        txtName6.visibility = GONE
        txtName7.visibility = GONE
        txtName8.visibility = GONE
        txtName9.visibility = GONE
        txtName10.visibility = GONE

        val intent = Intent(this@TodayActivity, PreviousActivity::class.java)

        var c=0

        val arr= arrayOf(txtName1,txtName2,txtName3,txtName4,txtName5,txtName6,txtName7,txtName8,txtName9,txtName10)


        btnAdd.setOnClickListener {
            if (c <= 9) {
                c++;
                arr[c].visibility = VISIBLE

            }
        }




        btnSave.setOnClickListener {



            val message1 = arr[0].text.toString()
            intent.putExtra("Message1", message1)


            val message2 = arr[1].text.toString()
            intent.putExtra("Message2", message2)


            val message3 = arr[2].text.toString()
            intent.putExtra("Message3", message3)


            val message4 = arr[3].text.toString()
            intent.putExtra("Message4", message4)


            val message5 = arr[4].text.toString()
            intent.putExtra("Message5", message5)


            val message6 = arr[5].text.toString()
            intent.putExtra("Message6", message6)


            val message7 = arr[6].text.toString()
            intent.putExtra("Message7", message7)


            val message8 = arr[7].text.toString()
            intent.putExtra("Message8", message8)


            val message9 = arr[8].text.toString()
            intent.putExtra("Message9", message9)


            val message10 = arr[9].text.toString()
            intent.putExtra("Message10", message10)








            startActivity(intent)
        }



    }




}

