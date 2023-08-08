package com.example.financialmanager.data.database
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.financialmanager.data.dao.UserDao
import com.example.financialmanager.model.UserModel


@Database(entities = [UserModel::class], version = 1)
abstract class AppDataBase(): RoomDatabase() {
    abstract fun userDao(): UserDao
    companion object {
        private lateinit var INSTANCE: AppDataBase

        fun getDataBase(context: Context): AppDataBase{
            if(!::INSTANCE.isInitialized) {
                synchronized(AppDataBase::class) {
                    INSTANCE = Room.databaseBuilder(context, AppDataBase::class.java, "financial_management")
                        .addMigrations()
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        private val MIGRATION_1_2: Migration = object : Migration(1,2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("DELETE FROM User ")
            }
        }


    }
}