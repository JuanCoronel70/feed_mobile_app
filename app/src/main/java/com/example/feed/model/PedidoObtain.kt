package com.example.feed.model
import com.google.gson.annotations.SerializedName

data class PedidoObtain(

    val id: String,
    val mesa: Int,
    val detalle: String,
    val estado: String,
    val mesero: String,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("updated_at") val updatedAt: String

)
