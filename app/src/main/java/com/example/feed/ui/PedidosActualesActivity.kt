package com.example.feed.ui

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.feed.R
import com.example.feed.viewmodel.VerPedidosViewModel

class PedidosActualesActivity: ComponentActivity() {

    private lateinit var backButton: ImageButton
    private val pedidoViewModel: VerPedidosViewModel by viewModels()
    private lateinit var pedidosRecyclerView: RecyclerView
    private lateinit var pedidosAdapter: PedidosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {

        // ================ Ui initialization =================== //
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ver_pedidos_activity)
        pedidosRecyclerView = findViewById(R.id.pedidosRecyclerView)
        pedidosRecyclerView.layoutManager = LinearLayoutManager(this)
        pedidosAdapter = PedidosAdapter()
        pedidosRecyclerView.adapter = pedidosAdapter

        // ================ vars initialization =================== //
        backButton = findViewById(R.id.backButton)
        backButton.setOnClickListener{
            finish()
        }

        // Observa los cambios en los pedidos
        pedidoViewModel.pedidos.observe(this, Observer { pedidos ->
            pedidos?.let {
                if (it.isNotEmpty()) {
                    Log.d("PedidosActivity", "Pedidos list size: ${it.size}")
                    pedidosAdapter.submitList(it)
                } else {
                    Log.d("PedidosActivity", "No hay pedidos disponibles")
                    Toast.makeText(this, "No hay pedidos disponibles", Toast.LENGTH_SHORT).show()
                }
            }
        })

        // Llama al método para obtener los pedidos
        Log.d("PedidosActivity", "Fetching pedidos")
        pedidoViewModel.fetchPedidos()


    }
}