package com.example.onefit

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Login : AppCompatActivity() {

    private lateinit var usernameEt: EditText
    private lateinit var passwordEt: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        usernameEt = findViewById(R.id.etUserName)
        passwordEt = findViewById(R.id.etPassword)
    }

    fun onLogin(view: View) {
        val userName = usernameEt.text.toString()
        val password = passwordEt.text.toString()
        val type = "login"
        val backgroundWorker = BackgroundWorker(this)
        backgroundWorker.execute(type, userName, password)
    }
}