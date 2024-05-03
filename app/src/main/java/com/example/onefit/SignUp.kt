package com.example.onefit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val registerButton = findViewById<Button>(R.id.signupbtn)
        registerButton.setOnClickListener {
        val intentRegister = Intent(this, HomeScreen::class.java)
            startActivity(intentRegister)
        }

    }
}