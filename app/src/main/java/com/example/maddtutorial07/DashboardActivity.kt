package com.example.maddtutorial07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView

class DashboardActivity : AppCompatActivity() {

    lateinit var rvUser:RecyclerView
    lateinit var updateView:LinearLayout
    lateinit var edtUpdateUsername:EditText
    lateinit var edtUpdatePassword:EditText
    lateinit var edtUpdatePasswordRe:EditText
    lateinit var btnUpdate:Button
    lateinit var btnDelete:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)
        rvUser = findViewById(R.id.rvUsers)
        updateView = findViewById(R.id.updateView)
        edtUpdateUsername = findViewById(R.id.edtUpdateUsername)
        edtUpdatePassword = findViewById(R.id.edtUpdatePassword)
        edtUpdatePasswordRe = findViewById(R.id.edtUpdatePasswordRe)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)

        btnUpdate.setOnClickListener {
            handleUpdate()
        }

        btnDelete.setOnClickListener {
            handleDelete()
        }
    }

    private fun  handleUpdate(){

    }

    private fun handleDelete(){

    }
}