package com.masorone.cleanarchitecture.data.repository


import com.masorone.cleanarchitecture.data.storage.models.User
import com.masorone.cleanarchitecture.data.storage.UserStorage
import com.masorone.cleanarchitecture.domain.models.SaveUserNameParam
import com.masorone.cleanarchitecture.domain.models.UserName
import com.masorone.cleanarchitecture.domain.repository.UserRepository


class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        return userStorage.save(mapToStorage(saveParam))
    }

    override fun getName(): UserName {
        return mapToDomain(userStorage.get())
    }

    private fun mapToStorage(saveParam: SaveUserNameParam): User {
        return User(
            firstName = saveParam.name,
            lastName = ""
        )
    }

    private fun mapToDomain(user: User): UserName {
        return UserName(
            firstName = user.firstName,
            lastName = user.lastName
        )
    }
}