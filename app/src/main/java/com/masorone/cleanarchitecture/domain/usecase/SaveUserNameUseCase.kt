package com.masorone.cleanarchitecture.domain.usecase

import com.masorone.cleanarchitecture.domain.models.SaveUserNameParam
import com.masorone.cleanarchitecture.domain.repository.UserRepository

class SaveUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(param: SaveUserNameParam): Boolean {
        return userRepository.saveName(saveUserNameParam = param)
    }

}