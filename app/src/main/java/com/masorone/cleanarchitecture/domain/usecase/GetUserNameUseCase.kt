package com.masorone.cleanarchitecture.domain.usecase

import com.masorone.cleanarchitecture.domain.models.UserName

class GetUserNameUseCase {

    fun execute(): UserName {
        return UserName(firstName = "Fedor", lastName = "Turkov")
    }

}