package com.masorone.cleanarchitecture.data.repository


import com.masorone.cleanarchitecture.data.storage.models.User
import com.masorone.cleanarchitecture.data.storage.UserStorage
import com.masorone.cleanarchitecture.domain.models.SaveUser
import com.masorone.cleanarchitecture.domain.models.GetUser
import com.masorone.cleanarchitecture.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveUser: SaveUser): Boolean {
        return userStorage.save(mapToStorage(saveUser))
    }

    override fun getName(): GetUser {
        return mapToDomain(userStorage.get())
    }

    private fun mapToStorage(saveParam: SaveUser): User {
        return User(
            firstName = saveParam.firstName,
            lastName = saveParam.lastName
        )
    }

    private fun mapToDomain(user: User): GetUser {
        return GetUser(
            firstName = user.firstName,
            lastName = user.lastName
        )
    }
}