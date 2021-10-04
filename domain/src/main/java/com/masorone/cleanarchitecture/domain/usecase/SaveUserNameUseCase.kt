package com.masorone.cleanarchitecture.domain.usecase

import com.masorone.cleanarchitecture.domain.models.SaveUser
import com.masorone.cleanarchitecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(saveUser: SaveUser): Boolean {
        return userRepository.saveName(saveUser = saveUser)
    }

}