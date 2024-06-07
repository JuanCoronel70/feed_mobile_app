package com.example.feed.model

data class Pedido(
    val mesa: Int,
    val detalle: String,
    val estado: String = "pendiente",
    val mesero: String
)