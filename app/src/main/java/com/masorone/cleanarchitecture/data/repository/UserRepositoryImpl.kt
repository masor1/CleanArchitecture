package com.masorone.cleanarchitecture.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.masorone.cleanarchitecture.domain.models.SaveUserNameParam
import com.masorone.cleanarchitecture.domain.models.UserName
import com.masorone.cleanarchitecture.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "first_name"
private const val KEY_LAST_NAME = "last_name"
private const val DEFAULT_NO_DATA = "NO DATA"

class UserRepositoryImpl(context: Context) : UserRepository {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveUserNameParam: SaveUserNameParam): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, saveUserNameParam.name).apply()
        return true
    }

    override fun getName(): UserName {
        val firstName =
            sharedPreferences.getString(KEY_FIRST_NAME, DEFAULT_NO_DATA) ?: DEFAULT_NO_DATA
        val lastName =
            sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_NO_DATA) ?: DEFAULT_NO_DATA
        return UserName(firstName = firstName, lastName = lastName)
    }

}