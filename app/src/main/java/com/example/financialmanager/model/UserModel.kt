package com.example.financialmanager.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "User")
data class UserModel(
    var name: String,
    var email: String,
    var phone: String,
    var password: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    
}
