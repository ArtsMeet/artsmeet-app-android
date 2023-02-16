package com.artsmeet.app.core.datastore.serializers

import android.util.Log
import androidx.datastore.core.Serializer
import com.artsmeet.app.core.model.authentication.User
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream

@Suppress("BlockingMethodInNonBlockingContext")
object UserDetailsSerializer: Serializer<User> {

    private const val EXCEPTION_TAG = "UserDetails"

    override val defaultValue: User
        get() = User(userName = null, email = null)

    override suspend fun readFrom(input: InputStream): User {
        return try {
            Json.decodeFromString(
                deserializer = User.serializer(),
                string = input.readBytes().decodeToString()
            )
        } catch (e:SerializationException){
            Log.e(EXCEPTION_TAG,e.message,e)
            defaultValue
        }
    }

    override suspend fun writeTo(t: User, output: OutputStream) {
        output.write(
            Json.encodeToString(
                serializer = User.serializer(),
                value = t
            ).encodeToByteArray()
        )
    }
}