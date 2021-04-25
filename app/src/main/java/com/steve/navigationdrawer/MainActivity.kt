package com.steve.navigationdrawer

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.steve.navigationdrawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        val homeFragment=HomeFragment()
        val messageFragment=MessageFragment()
        val searchFragment=SearchFragment()


    toggle=ActionBarDrawerToggle(this, binding.drawerlayout,R.string.open, R.string.close)
        binding.drawerlayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.action_home -> Toast.makeText(applicationContext,"selected home",Toast.LENGTH_LONG).show()
                R.id.action_search -> Toast.makeText(applicationContext,"clicked search",Toast.LENGTH_LONG).show()
                R.id.action_message ->Toast.makeText(applicationContext,"clicked message",Toast.LENGTH_LONG).show()
                R.id.profilr -> setProfile()

            }
            true
        }


    }

    private fun setProfile() {
        val intent=Intent(applicationContext,ProfileActivity::class.java)
        startActivity(intent)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }



}
