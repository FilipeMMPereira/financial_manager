package com.example.financialmanager.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.financialmanager.data.dao.UserDao
import com.example.financialmanager.model.UserModel
import com.example.financialmanager.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = UserRepository(application.applicationContext)

    private val listAllUser = MutableLiveData<List<UserModel>>()
    val users: LiveData<List<UserModel>> = listAllUser

    fun getAll(){
        listAllUser.value = repository.getAll()
    }

    fun delete(id: Int){
        repository.delete(id)
    }

}