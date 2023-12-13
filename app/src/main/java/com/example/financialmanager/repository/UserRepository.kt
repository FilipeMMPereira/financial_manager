package com.example.financialmanager.repository

import android.content.Context
import com.example.financialmanager.data.database.AppDataBase
import com.example.financialmanager.model.UserModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserRepository (context: Context){
    private val appDataBase = AppDataBase.getDataBase(context).userDao()

    // Singleton
//    companion object {
//        private lateinit var repository : UserRepository
//
//        fun getInstance(context: Context): UserRepository{
//            if(!::repository.isInitialized) {
//                repository = UserRepository(context)
//            }
//            return repository
//        }
//
//    }
    fun authenticate(email: String, password: String): Boolean {
        val user = appDataBase.getUserByEmailAndPassword(email, password)
        return user != null
    }

    fun insert(user: UserModel): Boolean {
        return appDataBase.insert(user) > 0
    }

    fun update(user: UserModel): Boolean {
        return appDataBase.update(user) > 0
    }

    fun delete (id: Int) {
//        val guest = get(id)
//        appDataBase.delete(guest)
    }

    fun getAll(): List<UserModel> {
        return  appDataBase.getAllUsers()
    }
}