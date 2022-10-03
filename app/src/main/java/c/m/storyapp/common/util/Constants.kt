package c.m.storyapp.common.util

import androidx.datastore.preferences.core.stringPreferencesKey
import c.m.storyapp.BuildConfig

object Constants {
    const val BASE_URL_API = BuildConfig.BASE_URL_API
    const val REGISTER_API = "register"
    const val LOGIN_API = "login"
    const val STORIES_API = "stories"
    const val NAME = "name"
    const val EMAIL = "email"
    const val PASSWORD = "password"
    val TOKEN = stringPreferencesKey(name = "x-token")
}