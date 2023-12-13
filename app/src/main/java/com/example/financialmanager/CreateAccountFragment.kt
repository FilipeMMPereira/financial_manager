package com.example.financialmanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.financialmanager.databinding.FragmentCreateAccountBinding
import com.example.financialmanager.model.UserModel
import com.example.financialmanager.viewModel.UserViewModel

class CreateAccountFragment : Fragment() {
    private lateinit var binding: FragmentCreateAccountBinding
    private lateinit var viewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateAccountBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding.floatingActionButton.setOnClickListener{
            Navigation.findNavController(view).popBackStack()
        }
        binding.buttonCreateAccount.setOnClickListener{
            val name = binding.editTextName.text.toString()
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()
            val phone = binding.editTextPhone.text.toString()
            val model = UserModel(name, email ,phone, password)
            viewModel.insert(model)
            viewModel.saveUser.observe(this) { observer ->
                Toast.makeText(requireContext(), observer, Toast.LENGTH_SHORT).show()
                Navigation.findNavController(view).popBackStack()
            }
        }
    }

}