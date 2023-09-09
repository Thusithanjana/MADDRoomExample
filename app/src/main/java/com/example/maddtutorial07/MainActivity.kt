package com.example.maddtutorial07

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.maddtutorial07.database.UserDB
import com.example.maddtutorial07.database.UserRepository
import com.example.maddtutorial07.viewModels.MainActivityData

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
        val viewModel = ViewModelProvider(this)[MainActivityData::class.java]

        btnLogin.setOnClickListener {
            handleLogin(viewModel)
        }

        btnRegister.setOnClickListener {
            handleRegister()
        }








    }

    private fun handleLogin(viewModel:MainActivityData){
        val repository = UserRepository(UserDB.getInstance(this))
        if(edtUsername.text.toString().isEmpty()){
            Toast.makeText(this,"Enter Username", Toast.LENGTH_LONG).show()
        }else{
            viewModel.setUser(edtUsername.text.toString(),repository)
        }
    }

    private fun handleRegister(){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)

    }
}