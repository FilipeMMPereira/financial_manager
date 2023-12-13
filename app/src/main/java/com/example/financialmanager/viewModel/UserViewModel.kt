package com.example.financialmanager.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.financialmanager.model.UserModel
import com.example.financialmanager.repository.UserRepository


class UserViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = UserRepository(application.applicationContext)

    private val listAllUser = MutableLiveData<List<UserModel>>()
    val users: LiveData<List<UserModel>> = listAllUser

    private val _saveUser = MutableLiveData<String>()
    val saveUser: LiveData<String> = _saveUser

    fun getAll(){
        listAllUser.value = repository.getAll()
    }

    fun delete(id: Int){
        repository.delete(id)
    }

    fun insert(user: UserModel){

        if (user.id.toInt() == 0){

           if(validator(user) && repository.insert(user)){
               _saveUser.value = "Insersao com sucesso"
               Log.i("Resultado","Sucesso total")
           }else{
               _saveUser.value = "Por favor, preencha todos os campos"
               Log.i("Resultado","Falha total")

           }
        }
    }

    private fun validator(user: UserModel) : Boolean{

        if (user.email.isEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(user.email).matches()) {
            return false
        }
        if (user.name.isEmpty()) {
            return false
        }
        if (user.email.isEmpty()) {
            return false
        }
        if (user.password.isEmpty()) {
            return false
        }
        return true
    }
    fun printUsers(){
        val users = repository.getAll()
        for (user in users) {
            Log.d("UserViewModel", "ID: ${user.id}, Name: ${user.name}, Email: ${user.email}")
        }
    }
}