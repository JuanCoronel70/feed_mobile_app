package com.example.feed.repository

import android.util.Log
import com.example.feed.model.Pedido
import com.example.feed.network.RetrofitInstance

class PedidoRepository {
    suspend fun createPedido(pedido: Pedido) {
        Log.d("Juan", "entro al repositorio")
        RetrofitInstance.api.createPedido(pedido)
    }
}