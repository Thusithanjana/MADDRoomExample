package com.example.maddtutorial07

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.maddtutorial07.database.User
import com.example.maddtutorial07.database.UserDB
import com.example.maddtutorial07.database.UserRepository
import com.example.maddtutorial07.viewModels.RegisterActivityData

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

        val repository = UserRepository(UserDB.getInstance(this))
        val viewModel = ViewModelProvider(this)[RegisterActivityData::class.java]

        viewModel.isInserted.observe(this, Observer {
            if(it == true){
                Toast.makeText(this, "Data inserted successfully", Toast.LENGTH_LONG).show()
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else if(it == false){
                Toast.makeText(this, "Data insertion failed", Toast.LENGTH_LONG).show()
            }
        })


        btnSave.setOnClickListener {
            handleSave(repository,viewModel)
        }

        btnCancel.setOnClickListener {
            handleCancel()
        }
    }

    private fun handleSave(repository: UserRepository,viewModel:RegisterActivityData){

        if(edtRegisterUsername.text.toString().isNotEmpty()&& edtRegisterPassword.text.toString().isNotEmpty()){
            if(edtRegisterPassword.text.toString()
                == edtRegisterPasswordRe.text.toString()){
                viewModel.insert(repository,
                    User(edtRegisterUsername.text.toString(),edtRegisterPassword.text.toString()))
            }else{
                Toast.makeText(this, "Password Mismatch", Toast.LENGTH_LONG).show()

            }
        }


    }

    private fun handleCancel(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)

    }
}