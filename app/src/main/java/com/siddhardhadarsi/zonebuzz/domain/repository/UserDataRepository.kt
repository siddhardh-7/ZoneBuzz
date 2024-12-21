package com.siddhardhadarsi.zonebuzz.domain.repository

import com.siddhardhadarsi.zonebuzz.domain.models.UserData
import kotlinx.coroutines.flow.Flow

interface UserDataRepository {
    fun useData() : Flow<UserData>
}