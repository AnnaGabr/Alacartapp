package com.example.alacartapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.view.WindowInsets
import android.view.WindowManager
import android.view.animation.AnimationUtils.loadAnimation
import androidx.appcompat.app.AppCompatActivity
import com.example.alacartapp.view.ui.activities.MainActivity
import kotlinx.android.synthetic.main.activity_splash.*



class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val splashAnimation= loadAnimation(this,R.anim.asset_fade_in)

        iv_splash_logo.startAnimation(splashAnimation)
        tv_splash_tittle.startAnimation (splashAnimation)
        tv_splash_tittle.startAnimation (splashAnimation)

        //lanzar SPLASHACTIVITY
         @Suppress("DEPRECATION")
         if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
             window.insetsController?.hide(WindowInsets.Type.statusBars())
         }else{
             window.setFlags(
                 WindowManager.LayoutParams.FLAG_FULLSCREEN,
                 WindowManager.LayoutParams.FLAG_FULLSCREEN
             )
         }

         //lanzar MAIN ACTIVITY
         @Suppress("DEPRECATION")
         Handler().postDelayed({
            startActivity(
                Intent(
                    this@SplashActivity,
                    MainActivity::class.java
                )
            )
            finish ()
        },3000 )
    }


}