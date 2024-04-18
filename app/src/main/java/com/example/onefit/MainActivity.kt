package com.example.onefit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main)

        val signupButton = findViewById<Button>(R.id.getStartedBtn)
        signupButton.setOnClickListener {
            val intentSignUp = Intent(this, SignUp::class.java)
            startActivity(intentSignUp)
        }

        val loginButton = findViewById<Button>(R.id.loginBtn)
        loginButton.setOnClickListener {
            val intentLogin = Intent(this, Login::class.java)
            startActivity(intentLogin)
        }

    }
}