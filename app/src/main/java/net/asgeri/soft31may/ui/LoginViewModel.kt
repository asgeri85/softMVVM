package net.asgeri.soft31may.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel() {

    val auth = FirebaseAuth.getInstance()

    val isLoading = MutableLiveData<Boolean>()
    val isSuccessLogin = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()


    fun login(email: String, password: String) {
        isLoading.value = true
        auth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                isSuccessLogin.value = true
                isLoading.value = false
            } else {
                isSuccessLogin.value = false
                isLoading.value = false
            }
        }
    }

    fun register(email: String, password: String) {
        isLoading.value = true
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                isSuccessLogin.value = true
                isLoading.value = false
            } else {
                isSuccessLogin.value = false
                isLoading.value = false
                errorMessage.value = it.exception?.localizedMessage.toString()
            }
        }
    }

}