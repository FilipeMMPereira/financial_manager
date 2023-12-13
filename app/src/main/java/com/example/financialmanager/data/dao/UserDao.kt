package com.example.financialmanager.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.financialmanager.model.UserModel

@Dao
interface UserDao {

    @Query("SELECT * FROM User WHERE email = :email AND password = :password")
    fun getUserByEmailAndPassword(email: String, password: String): UserModel?
    @Insert
    fun insert(user: UserModel): Long

    @Update
    fun update(user: UserModel): Int

    @Delete
    fun delete(user: UserModel)

    @Query("SELECT * FROM user")
    fun getAllUsers(): List<UserModel>

}