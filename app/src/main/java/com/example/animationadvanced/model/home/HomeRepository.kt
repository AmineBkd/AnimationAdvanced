package com.example.animationadvanced.model.home

import com.example.animationadvanced.di.dispatchers.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import java.util.concurrent.Flow
import javax.inject.Inject


class HomeRepository @Inject constructor() {
    private val homeDataStore: HomeDataStore = HomeDataStore()

    suspend fun getUserProfile(id: Int) = flow {
        emit(homeDataStore.getDataStoreUserProfiles().find {
            it?.id == id
        })
    }

    suspend fun getSessionUserProfile() = flow {
        emit(homeDataStore.getDataStoreUserProfiles().find {
            it?.id == 0
        })
    }
}
