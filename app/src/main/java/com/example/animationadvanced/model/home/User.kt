package com.example.animationadvanced.model.home

import java.util.Date

data class User(
    val id: Int,
    val userName: String,
    val lastName: String,
    val firstName: String,
    val birthday: Date,
    val friends: User? = null
)