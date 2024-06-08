package net.asgeri.soft31may.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import net.asgeri.soft31may.databinding.FragmentLoginBinding
import net.asgeri.soft31may.utils.gone
import net.asgeri.soft31may.utils.visible


class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel by viewModels<LoginViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()

        binding.button.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val email = binding.editTextEmail.text.toString().trim()
        val password = binding.editTextPassword.text.toString().trim()

        viewModel.register(email, password)
    }

    private fun observeData() {
        viewModel.isSuccessLogin.observe(viewLifecycleOwner) {
            if (it) {
                Toast.makeText(context, "Başarılı Giriş", Toast.LENGTH_SHORT).show()
            } else {
               // Toast.makeText(context, "Xetalı Giriş", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.isLoading.observe(viewLifecycleOwner){
            if (it) binding.progressBar2.visible() else binding.progressBar2.gone()
        }

        viewModel.errorMessage.observe(viewLifecycleOwner){
            Toast.makeText(context, it, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}