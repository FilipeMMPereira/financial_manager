package com.example.financialmanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.financialmanager.databinding.FragmentLoginBinding
import com.example.financialmanager.viewModel.UserViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding;
    private lateinit var viewModel: UserViewModel;
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.buttonLogin.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()

            if (viewModel.authenticate(email, password)) {
                Navigation.findNavController(view).navigate(R.id.homeFragment)
            } else {
                Toast.makeText(requireContext(), "Credenciais inválidas", Toast.LENGTH_SHORT).show()
            }
        }

        binding.textCreateAccount.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.createAccountFragment)
        }
    }

}