package com.masorone.cleanarchitecture.data.storage.sharedprefs

import android.content.Context
import android.content.SharedPreferences
import com.masorone.cleanarchitecture.data.storage.UserStorage
import com.masorone.cleanarchitecture.data.storage.models.User

private const val SHARED_PREFS_NAME = "shared_prefs_name"
private const val KEY_FIRST_NAME = "first_name"
private const val KEY_LAST_NAME = "last_name"
private const val DEFAULT_FIRSTNAME = "NO FIRSTNAME"
private const val DEFAULT_LASTNAME = "NO LASTNAME"

class SharedPrefUserStorage(context: Context) : UserStorage {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true
    }

    override fun get(): User {
        val firstName =
            sharedPreferences.getString(KEY_FIRST_NAME, DEFAULT_FIRSTNAME) ?: DEFAULT_FIRSTNAME
        val lastName =
            sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_LASTNAME) ?: DEFAULT_LASTNAME
        return User(firstName = firstName, lastName = lastName)
    }

}