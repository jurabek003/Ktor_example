package uz.turgunboyevjurabek.ktorexample.domain.madels

import kotlinx.serialization.Serializable

@Serializable
data class MyModelItem(
    val completed: Boolean?,
    val id: Int?,
    val title: String?,
    val userId: Int?
)