package uz.turgunboyevjurabek.ktorexample.domain.madels

import kotlinx.serialization.Serializable

@Serializable
data class MyPost (
    val body: String,
    val title: String,
    val userId: Int
)