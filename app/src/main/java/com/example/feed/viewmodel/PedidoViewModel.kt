// PedidoViewModel.kt
package com.example.feed.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feed.model.Pedido
import com.example.feed.repository.PedidoRepository
import kotlinx.coroutines.launch

class PedidoViewModel : ViewModel() {
    private val repository = PedidoRepository()

    fun createPedido(pedido: Pedido) {
        viewModelScope.launch {
            try {
                repository.createPedido(pedido)
                Log.d("PedidoViewModel", "Pedido enviado con éxito")
            } catch (e: Exception) {
                Log.e("PedidoViewModel", "Error al enviar el pedido", e)
            }
        }
    }
}
