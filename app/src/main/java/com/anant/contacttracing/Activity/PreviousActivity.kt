package com.anant.contacttracing.Activity

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.anant.contacttracing.R
import kotlinx.android.synthetic.main.activity_previous.*
import kotlinx.android.synthetic.main.activity_today.*
import java.text.DateFormat
import java.util.*

class PreviousActivity : AppCompatActivity() {


    lateinit var sharedPreferences: SharedPreferences

    lateinit var txtMessage1: TextView
    lateinit var txtMessage2: TextView
    lateinit var txtMessage3: TextView
    lateinit var txtMessage4: TextView
    lateinit var txtMessage5: TextView
    lateinit var txtMessage6: TextView
    lateinit var txtMessage7: TextView
    lateinit var txtMessage8: TextView
    lateinit var txtMessage9: TextView
    lateinit var txtMessage10: TextView
    var message1 = "Custom Message"
    var message2 = "Custom Message"
    var message3 = "Custom Message"
    var message4 = "Custom Message"
    var message5 = "Custom Message"
    var message6 = "Custom Message"
    var message7 = "Custom Message"
    var message8 = "Custom Message"
    var message9= "Custom Message"
    var message10 = "Custom Message"



    lateinit var txtDate:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



            setContentView(R.layout.activity_previous)


        sharedPreferences =
                getSharedPreferences(getString(R.string.preference_save), Context.MODE_PRIVATE)
            txtMessage1 = findViewById(R.id.txtMessage1)
            txtMessage2 = findViewById(R.id.txtMessage2)
            txtMessage3 = findViewById(R.id.txtMessage3)
            txtMessage4 = findViewById(R.id.txtMessage4)
            txtMessage5 = findViewById(R.id.txtMessage5)
            txtMessage6 = findViewById(R.id.txtMessage6)
            txtMessage7 = findViewById(R.id.txtMessage7)
            txtMessage8 = findViewById(R.id.txtMessage8)
            txtMessage9 = findViewById(R.id.txtMessage9)
            txtMessage10 = findViewById(R.id.txtMessage10)


            val arr = arrayOf(
                txtMessage1,
                txtMessage2,
                txtMessage3,
                txtMessage4,
                txtMessage5,
                txtMessage6,
                txtMessage7,
                txtMessage8,
                txtMessage9,
                txtMessage10
            )
            txtDate = findViewById(R.id.txtDate)
            // txtMessage = findViewById(R.id.txtMessage1)
            val rightNow = Calendar.getInstance()
            val currentDate: String = DateFormat.getInstance().format(rightNow.time)
            txtDate.text = currentDate



            if (intent != null) {
                message1 = intent.getStringExtra("Message1")
                message2 = intent.getStringExtra("Message2")
                message3 = intent.getStringExtra("Message3")
                message4 = intent.getStringExtra("Message4")
                message5 = intent.getStringExtra("Message5")
                message6 = intent.getStringExtra("Message6")
                message7 = intent.getStringExtra("Message7")
                message8 = intent.getStringExtra("Message8")
                message9 = intent.getStringExtra("Message9")
                message10 = intent.getStringExtra("Message10")
                txtMessage1.text = message1
                txtMessage2.text = message2
                txtMessage3.text = message3
                txtMessage4.text = message4
                txtMessage5.text = message5
                txtMessage6.text = message6
                txtMessage7.text = message7
                txtMessage8.text = message8
                txtMessage9.text = message9
                txtMessage10.text = message10
            }

        }

    }


