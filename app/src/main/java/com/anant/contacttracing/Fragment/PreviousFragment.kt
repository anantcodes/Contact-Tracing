package com.anant.contacttracing.Fragment

import android.os.Bundle
import android.content.Intent
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.anant.contacttracing.Activity.PreviousActivity
import com.anant.contacttracing.Activity.TodayActivity
import com.anant.contacttracing.R


class PreviousFragment : Fragment() {


    lateinit var btnNext: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_previous, container, false)

        btnNext=view.findViewById(R.id.btnNext)

        btnNext.setOnClickListener {

            val intent = Intent (activity, PreviousActivity::class.java)
            activity?.startActivity(intent)

        }

        return view


    }

}
