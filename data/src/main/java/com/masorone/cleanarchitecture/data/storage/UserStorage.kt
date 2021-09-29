package com.masorone.cleanarchitecture.data.storage

import com.masorone.cleanarchitecture.data.storage.models.User


interface UserStorage {
    fun save(user: User): Boolean
    fun get(): User
}