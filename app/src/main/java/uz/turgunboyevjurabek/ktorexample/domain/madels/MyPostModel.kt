package uz.turgunboyevjurabek.ktorexample.domain.madels

import kotlinx.serialization.Serializable

@Serializable
data class MyPostModel(
    val body: String,
    val id: Int,
    val title: String,
    val userId: Int
)