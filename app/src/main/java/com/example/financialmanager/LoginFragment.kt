package com.example.financialmanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.financialmanager.databinding.FragmentLoginBinding


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding;

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
        binding.buttonLogin.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()

            if(email == "filipe@gmail.com" && password == "123456") {
                Navigation.findNavController(view).navigate(R.id.homeFragment)
            } else {
                println("Esta tudo bem")
                Toast.makeText(requireContext(), "Credenciais inválidas", Toast.LENGTH_SHORT).show()

            }

        }

        binding.textCreateAccount.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.createAccountFragment)
        }
    }

}