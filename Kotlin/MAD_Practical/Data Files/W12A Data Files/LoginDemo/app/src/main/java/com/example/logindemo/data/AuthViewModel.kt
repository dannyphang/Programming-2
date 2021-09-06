package com.example.logindemo.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.ListenerRegistration

class AuthViewModel : ViewModel() {

    private val userLiveData = MutableLiveData<User>()
    private var listener: ListenerRegistration? = null

    // Remove snapshot listener when view model is destroyed
    override fun onCleared() {
        super.onCleared()
        listener?.remove()
    }

    // Return observable live data
    fun getUserLiveData(): LiveData<User> {
        return userLiveData
    }

    // Return user from live data
    fun getUser(): User? {
        return userLiveData.value
    }

    // TODO(1): Login
    suspend fun login(ctx: Context, email: String, password: String, remember: Boolean = false): Boolean {
        // TODO(1A): Get the user record with matching email + password
        //           Return false is no matching found


        // TODO(1B): Setup snapshot listener
        //           Update live data -> user


        // TODO(6A): Handle remember-me -> add shared preferences


        return true
    }

    // TODO(2): Logout
    fun logout(ctx: Context) {
        // TODO(2A): Remove snapshot listener
        //           Update live data -> null


        // TODO(6B): Handle remember-me -> clear shared preferences


    }

    // TODO(6): Get shared preferences
    private fun getPreferences(ctx: Context): Unit {

    }

    // TODO(7): Auto login from shared preferences
    suspend fun loginFromPreferences(ctx: Context) {

    }

}