package com.example.maddtutorial07.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.maddtutorial07.database.User
import com.example.maddtutorial07.database.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardActivityData:ViewModel() {

    private var _updateUser = MutableLiveData<User?>().apply { value = null }
    private val _users = MutableLiveData<List<User>>()


    val updateUser: LiveData<User?> = _updateUser
    val users:LiveData<List<User>> = _users


    fun loadData(repository: UserRepository){
        CoroutineScope(Dispatchers.Main).launch{
            _users.value = repository.getAll()
        }
    }

    fun updateData(repository: UserRepository, user: User){
        CoroutineScope(Dispatchers.IO).launch {
            repository.update(user)
            loadData(repository)
        }
    }

    fun deleteData(repository: UserRepository, user: User){
        CoroutineScope(Dispatchers.IO).launch {
            repository.delete(user)
            loadData(repository)
        }
    }

    fun setUser(user: User){
        _updateUser.value = user
    }
}