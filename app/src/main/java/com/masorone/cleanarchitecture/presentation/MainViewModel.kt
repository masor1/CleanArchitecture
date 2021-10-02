package com.masorone.cleanarchitecture.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.masorone.cleanarchitecture.data.repository.UserRepositoryImpl
import com.masorone.cleanarchitecture.data.storage.sharedprefs.SharedPrefUserStorage
import com.masorone.cleanarchitecture.domain.models.SaveUserNameParam
import com.masorone.cleanarchitecture.domain.models.UserName
import com.masorone.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.masorone.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainViewModel : ViewModel() {


    private val userRepository by lazy(LazyThreadSafetyMode.NONE) {
        UserRepositoryImpl(
            userStorage = SharedPrefUserStorage(context = applicationContext)
        )
    }

    private val getUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        GetUserNameUseCase(
            userRepository = userRepository
        )
    }

    private val saveUserNameUseCase by lazy(LazyThreadSafetyMode.NONE) {
        SaveUserNameUseCase(
            userRepository = userRepository
        )
    }

    init {
        Log.e("AAA", "VM created")
    }

    override fun onCleared() {
        Log.e("AAA", "VM cleared")
        super.onCleared()
    }

    fun save(text: String): String {
        val params = SaveUserNameParam(name = text)
        val result: Boolean = saveUserNameUseCase.execute(param = params)
        return "save result = $result"
    }

    fun load(): String {
        val userName: UserName = getUserNameUseCase.execute()
        return "${userName.firstName} ${userName.lastName}"
    }
}