package com.anant.contacttracing.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.anant.contacttracing.Activity.TodayActivity
import com.anant.contacttracing.R
import kotlinx.android.synthetic.main.fragment_home.*


lateinit var btnStart1: Button
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_home, container, false)

        btnStart1=view.findViewById(R.id.btnStart)

        btnStart1.setOnClickListener {

            val intent = Intent (activity, TodayActivity::class.java)
           activity?.startActivity(intent)

        }
        return view
    }


}
