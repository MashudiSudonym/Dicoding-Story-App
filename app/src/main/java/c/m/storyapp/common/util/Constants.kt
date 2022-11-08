package c.m.storyapp.common.util

import androidx.datastore.preferences.core.stringPreferencesKey
import c.m.storyapp.BuildConfig

object Constants {
    const val BASE_URL_API = BuildConfig.BASE_URL_API
    const val REGISTER_API = "register"
    const val LOGIN_API = "login"
    const val STORIES_API = "stories"
    const val PARAM_LOCATION = "stories?location=1"
    const val NAME = "name"
    const val EMAIL = "email"
    const val PASSWORD = "password"
    val TOKEN = stringPreferencesKey(name = "x-token")
    const val AUTHORIZATION = "Authorization"
    const val BEARER = "Bearer "
    const val STORY_ID = "story id"
    const val BLANK_STRING = ""
    const val PHOTO = "photo"
    const val DESCRIPTION = "description"
    const val CAMERA_X_RESULT = 200
    const val REQUEST_CODE_PERMISSIONS = 10
    const val FILENAME_FORMAT = "dd-MMM-yyyy"
    const val PICTURE = "picture"
    const val IS_BACK_CAMERA = "isBackCamera"
    const val INTENT_TYPE = "image/*"
    const val CHOOSE_A_PICTURE =  "Choose a Picture"
    const val SUFFIX_PHOTO_FILE_FORMAT = ".jpg"
    const val TEXT_PLAIN = "text/plain"
    const val IMAGE_JPEG = "image/jpeg"
    const val IMAGE = "image"
    const val TITLE = "title"
}