package com.masorone.cleanarchitecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.masorone.cleanarchitecture.domain.models.SaveUser
import com.masorone.cleanarchitecture.domain.models.GetUser
import com.masorone.cleanarchitecture.domain.usecase.GetUserNameUseCase
import com.masorone.cleanarchitecture.domain.usecase.SaveUserNameUseCase

class MainViewModel(
    private val getUserNameUseCase: GetUserNameUseCase,
    private val saveUserNameUseCase: SaveUserNameUseCase
) : ViewModel() {

    private val resultSaveMutable = MutableLiveData<String>()
    private val firstNameMutable = MutableLiveData<String>()
    private val lastNameMutable = MutableLiveData<String>()

    val resultSave: LiveData<String> = resultSaveMutable
    val firstName: LiveData<String> = firstNameMutable
    val lastName: LiveData<String> = lastNameMutable

    fun save(firstName: String, lastName: String) {
        val firstNameSave: String = if (firstName == "") {
            DEFAULT_FIRSTNAME
        } else {
            firstName
        }

        val lastNameSave: String = if (lastName == "") {
            DEFAULT_FIRSTNAME
        } else {
            lastName
        }
        val saveUser = SaveUser(firstName = firstNameSave, lastName = lastNameSave)
        val result: Boolean = saveUserNameUseCase.execute(saveUser = saveUser)
        resultSaveMutable.value = "save result = $result"
    }

    fun load() {
        val userName: GetUser = getUserNameUseCase.execute()
        firstNameMutable.value = userName.firstName
        lastNameMutable.value = userName.lastName
    }

    companion object {
        private const val DEFAULT_FIRSTNAME = "NO FIRSTNAME"
        private const val DEFAULT_LASTNAME = "NO LASTNAME"
    }
}