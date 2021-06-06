package com.syafii.mvvmbasic.viewmodels

import android.content.Context
import androidx.lifecycle.*
import com.syafii.mvvmbasic.repository.contract.LoginContractRepo
import com.syafii.mvvmbasic.repository.payload.requests.LoginRequest
import com.syafii.mvvmbasic.views.state.LoginState
import kotlinx.coroutines.launch

class LoginViewModelFactory(
    private val repository: LoginContractRepo
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(repository) as T
    }

}
class LoginViewModel(
    private val repository: LoginContractRepo
) : ViewModel() {
    private val _login = MutableLiveData<LoginState>()
    val login: LiveData<LoginState>
        get() = _login


    fun getLogin(email: String, password: String) {
        _login.postValue(LoginState.Loading("Loading..."))
        viewModelScope.launch {
            try {
                val payload = LoginRequest(email, password)
                val responses = repository.getLogin(payload)
                _login.postValue(LoginState.SuccessLogin(responses))
            } catch (e: Exception) {
                e.printStackTrace()
                _login.postValue(LoginState.Error(e))
            }
        }
    }

}