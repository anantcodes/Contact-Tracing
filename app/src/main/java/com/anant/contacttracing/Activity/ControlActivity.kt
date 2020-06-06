package com.anant.contacttracing.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
//import android.widget.Toolbar
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.anant.contacttracing.*
import com.anant.contacttracing.Fragment.*
import com.google.android.material.navigation.NavigationView

class ControlActivity : AppCompatActivity() {


    lateinit var drawerLayout: DrawerLayout
    lateinit var coordinatorLayout: CoordinatorLayout
    lateinit var toolbar: Toolbar
    lateinit var frameLayout: FrameLayout
    lateinit var navigationView: NavigationView

    var previousMenuItem:MenuItem?=null
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_control)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        drawerLayout=findViewById(R.id.drawerLayout)
        coordinatorLayout=findViewById(R.id.coordinatorLayout)
        toolbar=findViewById(R.id.toolbar)
        frameLayout=findViewById(R.id.frame)
        navigationView=findViewById(R.id.navigationView)

setUpToolbar()
        openHome()

        val actionBarDrawerToggle=ActionBarDrawerToggle(this@ControlActivity,drawerLayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        navigationView.setNavigationItemSelectedListener{

            if(previousMenuItem != null){
                previousMenuItem?.isChecked=false
            }
            it.isCheckable=true
            it.isChecked=true
            previousMenuItem=it

            when(it.itemId)
            {
                R.id.home ->{
                    openHome()
                    drawerLayout.closeDrawers()
                }
                R.id.previous ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        PreviousFragment()
                    ).addToBackStack("Previous").commit()
                    supportActionBar?.title="Previous Records"
                    drawerLayout.closeDrawers()
                }
                R.id.others ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        OthersFragment()
                    ).addToBackStack("Others").commit()
                    supportActionBar?.title="Others"
                    drawerLayout.closeDrawers()
                }
                R.id.facts ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        FactsFragment()
                    ).addToBackStack("Facts").commit()
                    supportActionBar?.title="Facts"
                    drawerLayout.closeDrawers()
                }
                R.id.faqs ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        FaqsFragment()
                    ).addToBackStack("Faqs").commit()
                    supportActionBar?.title="FAQs"
                    drawerLayout.closeDrawers()
                }
                R.id.aboutApp ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        AboutAppFragment()
                    ).addToBackStack("AboutApp").commit()
                    supportActionBar?.title="About App"
                    drawerLayout.closeDrawers()
                }
                R.id.aboutDeveloper ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        AboutDeveloperFragment()
                    ).addToBackStack("About Developer").commit()
                    supportActionBar?.title="About Developer"
                    drawerLayout.closeDrawers()
                }
                R.id.profile ->{
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        ProfileFragment()
                    ).addToBackStack("Profile").commit()
                    supportActionBar?.title="Your Profile"
                    drawerLayout.closeDrawers()
                }
                R.id.logout ->{
                    Toast.makeText(this@ControlActivity,"Clicked on logout",Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@ControlActivity, LoginActivity::class.java))
                    sharedPreferences.edit().clear().apply()
                    finish()
                }



            }
            return@setNavigationItemSelectedListener true
        }


    }


    fun setUpToolbar(){
        setSupportActionBar(toolbar)
        supportActionBar?.title="Toolbar Title"
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id=item.itemId
        if(id==android.R.id.home)
        {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        return super.onOptionsItemSelected(item)
    }
    fun openHome(){
        val fragment= HomeFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame,fragment)
        transaction.commit()
        supportActionBar?.title="Home"
        navigationView.setCheckedItem(R.id.txtHome)
    }
    override fun onBackPressed() {
        val frag = supportFragmentManager.findFragmentById(R.id.frame)

        when(frag){
            !is HomeFragment -> openHome()

            else -> super.onBackPressed()
        }
    }

}
