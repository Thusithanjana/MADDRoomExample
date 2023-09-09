package com.example.maddtutorial07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {

    lateinit var edtRegisterUsername:EditText
    lateinit var edtRegisterPassword:EditText
    lateinit var edtRegisterPasswordRe:EditText
    lateinit var btnSave:Button
    lateinit var btnCancel:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        edtRegisterUsername = findViewById(R.id.edtRegisterUsername)
        edtRegisterPassword = findViewById(R.id.edtRegisterPassword)
        edtRegisterPasswordRe = findViewById(R.id.edtRegisterPasswordRe)
        btnSave = findViewById(R.id.btnSave)
        btnCancel = findViewById(R.id.btnCancel)


        btnSave.setOnClickListener {
            handleSave()
        }

        btnCancel.setOnClickListener {
            handleCancel()
        }
    }

    private fun handleSave(){

    }

    private fun handleCancel(){

    }
}