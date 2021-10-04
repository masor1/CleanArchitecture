package com.masorone.cleanarchitecture.domain.repository

import com.masorone.cleanarchitecture.domain.models.SaveUser
import com.masorone.cleanarchitecture.domain.models.GetUser

interface UserRepository {
    fun saveName(saveUser: SaveUser): Boolean
    fun getName(): GetUser
}