package com.masorone.cleanarchitecture.domain.usecase

import com.masorone.cleanarchitecture.domain.models.GetUser
import com.masorone.cleanarchitecture.domain.repository.UserRepository

class GetUserNameUseCase(private val userRepository: UserRepository) {

    fun execute(): GetUser {
        return userRepository.getName()
    }
}