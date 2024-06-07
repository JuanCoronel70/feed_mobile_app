// PedidoViewModel.kt
package com.example.feed.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feed.model.Pedido
import com.example.feed.repository.PedidoRepository
import kotlinx.coroutines.launch

class PedidoViewModel : ViewModel() {
    private val repository = PedidoRepository()

    private val _pedidoResultado = MutableLiveData<Boolean>()
    val pedidoResultado: LiveData<Boolean> get() = _pedidoResultado

    fun createPedido(pedido: Pedido) {
        viewModelScope.launch {
            try {
                repository.createPedido(pedido)
                _pedidoResultado.value = true
            } catch (e: Exception) {
                _pedidoResultado.value = false
            }
        }
    }
}
