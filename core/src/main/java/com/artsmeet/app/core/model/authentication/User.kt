package com.artsmeet.app.core.model.authentication

@kotlinx.serialization.Serializable
data class User(
    val displayName: String? = null,
    val userName: String?,
    val phoneNumber: Long? = null,
    val countryCode: Int? = null,
    val email: String?,
    val provider: Provider = Provider.EMAIL_AND_PASSWORD,
    val photoUrl: String? = null,
    val follower: Int = 0,
    val following: Int = 0

) {
    @kotlinx.serialization.Serializable
    enum class Provider {
        GOOGLE,
        EMAIL_AND_PASSWORD
    }
}
