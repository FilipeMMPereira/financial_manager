package com.example.financialmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import com.example.financialmanager.databinding.ActivityMainBinding
import androidx.navigation.fragment.NavHostFragment
import com.example.financialmanager.model.UserModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater);
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        val currentDestination = navController.currentDestination?.id
        val isLoginPage = currentDestination == R.id.loginFragment

        if (isLoginPage) {
            binding.buttonNavigation.isVisible = false
        }

    }

    private fun testDB(){
        lifecycleScope.launch {
            val newUser = UserModel("John Doe", "john@example.com", "123456789", "password123")
//            AppDatabase.UserDao
        }
    }

}

