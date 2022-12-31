package com.artsmeet.app.core.model.authentication

data class User(
    val displayName: String,
    val userName: String,
    val phoneNumber: Long,
    val countryCode: Int,
    val email: String,
    val provider: Provider,
    val photoUrl: String,
    val follower: Int,
    val following: Int

) {
    enum class Provider {
        GOOGLE,
        EMAIL_AND_PASSWORD
    }
}
