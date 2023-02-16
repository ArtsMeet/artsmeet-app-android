package com.artsmeet.app.core

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import com.artsmeet.app.core.androidBaseComponent.prefDataStore
import com.artsmeet.app.core.androidBaseComponent.userDataStore
import com.artsmeet.app.core.extension.collectNonBlocking
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

val ioScope = CoroutineScope(Dispatchers.IO + Job())

object Settings {

    var isUserAuthenticated
        get() = ArtsMeet.applicationContext.prefDataStore.getValue(Preferences.IS_USER_AUTHENTICATED)
        set(value) = ArtsMeet.applicationContext.prefDataStore.setValue(
            Preferences.IS_USER_AUTHENTICATED,
            value
        )

    var userData
        get() = ArtsMeet.applicationContext.userDataStore.data
        set(value) = value.collectNonBlocking { user ->
            ArtsMeet.applicationContext.userDataStore.updateData {
                user
            }
        }


}

private fun <T : Any> DataStore<androidx.datastore.preferences.core.Preferences>.getValue(key: androidx.datastore.preferences.core.Preferences.Key<T>) =
    data.map {
        it[key]
    }

fun <T : Any> DataStore<androidx.datastore.preferences.core.Preferences>.setValue(
    key: androidx.datastore.preferences.core.Preferences.Key<T>,
    value: Flow<T?>
) {
    ioScope.launch {
        value.collectLatest {
            if (it != null)
                edit { pref ->
                    pref[key] = it
                }
        }
    }
}

object Preferences {
    val IS_USER_AUTHENTICATED = booleanPreferencesKey(Constants.IS_USER_AUTHENTICATED)
    /*val USER_DISPLAY_NAME = stringPreferencesKey(Constants.USER_DISPLAY_NAME)
    val USER_NAME = stringPreferencesKey(Constants.USER_NAME)
    val USER_PHONE_NUMBER = stringPreferencesKey(Constants.USER_PHONE_NUMBER)
    val COUNTRY_CODE = stringPreferencesKey(Constants.COUNTRY_CODE)
    val USER_EMAIL = stringPreferencesKey(Constants.USER_EMAIL)
    val PROVIDER = stringPreferencesKey(Constants.PROVIDER)
    val USER_PHOTO_URL = stringPreferencesKey(Constants.USER_PHOTO_URL)
    val USER_FOLLOWERS = intPreferencesKey(Constants.USER_FOLLOWERS)
    val USER_FOLLOWING = intPreferencesKey(Constants.USER_FOLLOWING)*/
}