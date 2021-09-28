package com.masorone.cleanarchitecture.domain.repository

import com.masorone.cleanarchitecture.domain.models.SaveUserNameParam
import com.masorone.cleanarchitecture.domain.models.UserName

interface UserRepository {
    fun saveName(saveUserNameParam: SaveUserNameParam): Boolean
    fun getName(): UserName
}