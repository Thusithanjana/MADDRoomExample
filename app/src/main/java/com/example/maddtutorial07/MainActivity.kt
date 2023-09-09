package com.example.maddtutorial07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {

    lateinit var edtUsername:EditText
    lateinit var edtPassword:EditText
    lateinit var btnLogin:Button
    lateinit var btnRegister:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtUsername = findViewById(R.id.edtUsername)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
        btnRegister = findViewById(R.id.btnRegister)

        btnLogin.setOnClickListener {
            handleLogin()
        }

        btnRegister.setOnClickListener {
            handleRegister()
        }
    }

    private fun handleLogin(){

    }

    private fun handleRegister(){

    }
}