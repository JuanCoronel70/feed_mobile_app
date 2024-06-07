package com.example.feed.network

import com.example.feed.model.Pedido
import com.example.feed.model.PedidoObtain
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("api/v1/pedidos")
    suspend fun createPedido(@Body pedido: Pedido)

    @GET("api/v1/pedidos")
    suspend fun getPedidos(): List<PedidoObtain>
}
