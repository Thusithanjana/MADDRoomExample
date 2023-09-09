package com.example.maddtutorial07

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.maddtutorial07.adapter.UserAdapter
import com.example.maddtutorial07.database.User
import com.example.maddtutorial07.database.UserDB
import com.example.maddtutorial07.database.UserRepository
import com.example.maddtutorial07.viewModels.DashboardActivityData

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
        val repository = UserRepository(UserDB.getInstance(this))
        val viewModel = ViewModelProvider(this)[DashboardActivityData::class.java]

        rvUser = findViewById(R.id.rvUsers)
        updateView = findViewById(R.id.updateView)
        edtUpdateUsername = findViewById(R.id.edtUpdateUsername)
        edtUpdatePassword = findViewById(R.id.edtUpdatePassword)
        edtUpdatePasswordRe = findViewById(R.id.edtUpdatePasswordRe)
        btnUpdate = findViewById(R.id.btnUpdate)
        btnDelete = findViewById(R.id.btnDelete)

        rvUser.layoutManager = LinearLayoutManager(this)

        updateView.isVisible = false

        btnUpdate.setOnClickListener {
            handleUpdate(viewModel,repository)
        }

        btnDelete.setOnClickListener {
            handleDelete(viewModel,repository)
        }

        viewModel.loadData(repository)

        viewModel.users.observe(this, Observer {
            val adapter = UserAdapter(it,viewModel)
            rvUser.adapter = adapter
        })

        viewModel.updateUser.observe(this, Observer {
            if(it != null){
                updateView.isVisible = true
                edtUpdateUsername.setText(it.userName)
            }
        })
    }

    private fun  handleUpdate(viewModel:DashboardActivityData,repository: UserRepository){

        val user: User? = viewModel.updateUser.value
        if(edtUpdatePassword.text.toString() == edtUpdatePasswordRe.text.toString()){
            user?.password = edtUpdatePassword.text.toString()
            if(user != null){
                viewModel.updateData(repository,user)
                Toast.makeText(this,"Data updated successfully",Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this,"Password Mismatch",Toast.LENGTH_LONG).show()

        }


    }

    private fun handleDelete(viewModel:DashboardActivityData,repository: UserRepository){
        val user: User? = viewModel.updateUser.value
        if (user != null) {
            viewModel.deleteData(repository,user)
            Toast.makeText(this,"User Deleted Successfully",Toast.LENGTH_LONG).show()
        }
    }
}