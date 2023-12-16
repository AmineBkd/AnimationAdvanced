package com.example.animationadvanced.model.home

import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class HomeDataStore {
    private val fakeDataUserProfile: List<User?> = listOf(
        SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE).parse("28/03/1998")?.let { Date(it.time) }
            ?.let {
                User(
                    0,
                    "username",
                    "lastname",
                    "firstname",
                    it
                )
            },
        SimpleDateFormat("dd/MM/yyyy", Locale.FRANCE).parse("28/03/1992")?.let { Date(it.time) }
            ?.let {
                User(
                    1,
                    "username1",
                    "lastname1",
                    "firstname1",
                    it
                )
            }
    )

    suspend fun getDataStoreUserProfiles(): List<User?> {
        delay(100) //emulating request
        return fakeDataUserProfile
    }
}