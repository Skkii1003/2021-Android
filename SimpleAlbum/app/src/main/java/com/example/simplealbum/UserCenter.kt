package com.example.simplealbum


object UserCenter {

    // user email -> user obj
    private val users = mutableMapOf<String, User>()

    var signInUser: User? = null

    fun addUser(user: User) {
        users[user.email] = user
    }

    fun getUserByEmail(email: String): User? {
        return users[email]
    }
}