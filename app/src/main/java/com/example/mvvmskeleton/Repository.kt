package com.example.mvvmskeleton

import com.example.mvvmskeleton.Model.User
import kotlinx.coroutines.delay

class Repository {
    suspend fun fetchUserDetails() : User {
        delay(2000)
        return User(name = "Hamza", age = 26)
    }
}