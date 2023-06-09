package com.example.clonesocialapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.Profile
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.clonesocialapp.fragments.FavFragment
import com.example.clonesocialapp.fragments.HomeFragment
import com.example.clonesocialapp.fragments.ProfileFragment
import com.example.clonesocialapp.fragments.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNav=findViewById(R.id.bottom_navigation) as BottomNavigationView
        bottomNav.setOnItemSelectedListener {MenuItem->
            when(MenuItem.itemId){
                R.id.homePage ->{
                    jumpFragment(HomeFragment())
                    true
                }
                R.id.discoveryPage ->{
                    jumpFragment(SearchFragment())
                    true
                }
                R.id.favsPage ->{
                    jumpFragment(FavFragment())
                    true
                }
                R.id.profilePage ->{
                    jumpFragment(ProfileFragment())
                    true
                }

                else -> {false}
            }

        }
    }
    private fun jumpFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(com.google.android.material.R.id.container,fragment)
        transaction.commit()
    }
}