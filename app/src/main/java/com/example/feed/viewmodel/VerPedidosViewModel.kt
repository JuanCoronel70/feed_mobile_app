package com.example.feed.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.feed.model.Pedido
import com.example.feed.model.PedidoObtain
import com.example.feed.repository.PedidoRepository
import kotlinx.coroutines.launch

class VerPedidosViewModel: ViewModel() {

    private val repository = PedidoRepository()

    private val _pedidos = MutableLiveData<List<PedidoObtain>>()
    val pedidos: LiveData<List<PedidoObtain>> get() = _pedidos

    fun fetchPedidos() {
        viewModelScope.launch {
            try {
                val pedidosList = repository.obtenerPedidos()
                Log.d("PedidoViewModel", "Pedidos fetched: ${pedidosList.size}")
                _pedidos.value = pedidosList
            } catch (e: Exception) {
                Log.e("PedidoViewModel", "Error fetching pedidos", e)
                _pedidos.value = emptyList()
            }
        }
    }


}