package com.example.maddtutorial07.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.maddtutorial07.database.User
import com.example.maddtutorial07.database.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class RegisterActivityData:ViewModel() {
    private val _isInserted = MutableLiveData<Boolean?>().apply { value = null }

    val isInserted: LiveData<Boolean?> = _isInserted

    fun insert(userRepository: UserRepository, user: User){
        try {
            CoroutineScope(Dispatchers.IO).launch{
                userRepository.insert(user)

            }
            _isInserted.value = true
        }catch (e:Exception){
            _isInserted.value =false
        }
    }
}