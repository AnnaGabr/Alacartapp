package com.example.alacartapp.view.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.alacartapp.R
import com.example.alacartapp.databinding.ActivityLoginBinding
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    val AUTH_REQUEST_CODE = 1234
    lateinit var firebaseAuth : FirebaseAuth
    lateinit var listener: FirebaseAuth.AuthStateListener
    lateinit var providers: List<AuthUI.IdpConfig>

    override fun onStart() {
        super.onStart()
        firebaseAuth.addAuthStateListener(listener)
    }

    override fun onStop() {
        super.onStop()
        if (listener != null)
            firebaseAuth.removeAuthStateListener(listener)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(R.layout.activity_login)

        providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build()
        )
        val intent = Intent(this,MainActivity::class.java)
        firebaseAuth = FirebaseAuth.getInstance()
        listener = FirebaseAuth.AuthStateListener{ p0 ->
            val user = p0.currentUser
            if (user != null){
                startActivity(intent)
            }else{
                startActivityForResult(AuthUI.getInstance()
                    .createSignInIntentBuilder()
                    .setAvailableProviders(providers)
                    .build(),AUTH_REQUEST_CODE)
            }

        }
    }
}