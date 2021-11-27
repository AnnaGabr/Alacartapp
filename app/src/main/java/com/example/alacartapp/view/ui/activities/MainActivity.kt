package com.example.alacartapp.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alacartapp.R
import com.example.alacartapp.view.ui.fragments.MenuFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, MenuFragment())
                .commit()
        }
    }
}