package c.m.storyapp.list_story.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ListStory(
    val id: String,
    val name: String,
    val description: String,
    val photoUrl: String,
    val createdAt: String,
    val latitude: Double,
    val longitude: Double,
) : Parcelable
