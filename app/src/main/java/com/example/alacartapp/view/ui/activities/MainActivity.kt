package com.example.alacartapp.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.alacartapp.R
import com.example.alacartapp.databinding.ActivityMainBinding
import com.example.alacartapp.view.ui.fragments.MenuFragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigationrail.NavigationRailView
import android.widget.Toast
import com.example.alacartapp.view.ui.fragments.Pedido
import com.example.alacartapp.view.ui.fragments.Waiter_login

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bnavMenu?.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navMenu -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContent, MenuFragment()).commit()
                    //Toast.makeText(this, "menu", Toast.LENGTH_SHORT).show()
                    true
                }

                R.id.navOrder -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContent, Pedido()).commit()
                    //Toast.makeText(this, "pedido", Toast.LENGTH_SHORT).show()
                    true
                }

                else -> {
                    supportFragmentManager.beginTransaction().replace(R.id.fragmentContent, Waiter_login()).commit()
                    //Toast.makeText(this, "servic", Toast.LENGTH_SHORT).show()
                    true
                }
            }
        }
    }



}