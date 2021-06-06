package com.syafii.mvvmbasic.views

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.syafii.mvvmbasic.databinding.ActivityLoginBinding
import com.syafii.mvvmbasic.repository.client.UserClient
import com.syafii.mvvmbasic.repository.contract.LoginContractImpl
import com.syafii.mvvmbasic.viewmodels.LoginViewModel
import com.syafii.mvvmbasic.viewmodels.LoginViewModelFactory
import com.syafii.mvvmbasic.views.state.LoginState
import timber.log.Timber

class LoginActivity : AppCompatActivity() {
    private val TAG = LoginActivity::class.java.simpleName
    private val binding by lazy { ActivityLoginBinding.inflate(layoutInflater)}
    private val service by lazy { UserClient.loginServices }
    private val repository by lazy { LoginContractImpl(service) }
    private val loginVMFactory by lazy { LoginViewModelFactory(repository) }
    private val loginViewModel by viewModels<LoginViewModel>{loginVMFactory}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setView()
        setObserver()
    }

    private fun setObserver() {
        loginViewModel.login.observe(this, { login ->
            when(login){
                is LoginState.Loading -> {Timber.tag(TAG).d("Loading..")}
                is LoginState.SuccessLogin -> {Timber.tag(TAG).d("Suksess Login")}
                is LoginState.Error -> {Timber.tag(TAG).d("error..")}
            }
        })
    }

    private fun setView() {
        binding.run {
            btLogin.setOnClickListener {
                val email = tieEmail.text.toString()
                val password = tiePass.text.toString()
                if (email.isNotEmpty() && password.isNotEmpty()){
                    loginViewModel.getLogin(email,password)
                }
            }
        }
    }
}