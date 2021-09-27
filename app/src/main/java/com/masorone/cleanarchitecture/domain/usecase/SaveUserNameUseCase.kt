package com.masorone.cleanarchitecture.domain.usecase

import com.masorone.cleanarchitecture.domain.models.SaveUserNameParam

class SaveUserNameUseCase {

    fun execute(param: SaveUserNameParam): Boolean {
        return param.name.isNotEmpty()
    }

}