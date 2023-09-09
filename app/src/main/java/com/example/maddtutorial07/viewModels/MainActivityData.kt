package com.example.maddtutorial07.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.maddtutorial07.database.User
import com.example.maddtutorial07.database.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityData:ViewModel() {
    private val _user = MutableLiveData<User?>().apply { value = null }
    val user: LiveData<User?> = _user
    val error = MutableLiveData<String>().apply { value = "" }
    fun setUser(name:String,repository: UserRepository){
        try {
            CoroutineScope(Dispatchers.Main).launch {
                _user.value = repository.getOne(name)
            }
        }catch (e:Exception){
            error.value = "No user with that username"
        }
    }
}