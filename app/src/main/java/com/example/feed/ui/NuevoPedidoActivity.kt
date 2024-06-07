package com.example.feed.ui

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import android.widget.EditText
import android.widget.FrameLayout
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import com.example.feed.R
import com.example.feed.model.Pedido
import com.example.feed.viewmodel.PedidoViewModel

class NuevoPedidoActivity : ComponentActivity() {
    private lateinit var backButton: ImageButton
    private lateinit var numeroMesaEditText: EditText
    private lateinit var descripcionEditText: EditText
    private lateinit var confirmarPedidoFrame: FrameLayout

    private lateinit var nombreMesero: String
    private lateinit var numeroMesa: String
    private lateinit var descripcionPedido: String

    private val pedidoViewModel: PedidoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.crear_pedido_activity)

        nombreMesero = intent.getStringExtra("user").toString()
        backButton = findViewById(R.id.backButton)
        numeroMesaEditText = findViewById(R.id.editTextText)
        descripcionEditText = findViewById(R.id.editTextText2)
        confirmarPedidoFrame = findViewById(R.id.frame3)

        backButton.setOnClickListener {
            finish()
        }

        confirmarPedidoFrame.setOnClickListener {
            numeroMesa = numeroMesaEditText.text.toString()
            descripcionPedido = descripcionEditText.text.toString()

            showConfirmDialog(numeroMesa, descripcionPedido)
        }
    }

    private fun showConfirmDialog(numeroMesa: String, descripcionPedido: String) {
        val dialogBuilder = AlertDialog.Builder(this)

        dialogBuilder.setMessage("Esta es la información del pedido:\n\nNúmero de Mesa: $numeroMesa\nDescripción del Pedido:\n\n$descripcionPedido")
            .setCancelable(false)
            .setPositiveButton("Confirmar") { dialog, id ->
                val pedido = Pedido(
                    mesa = numeroMesa.toInt(),
                    detalle = descripcionPedido,
                    mesero = nombreMesero
                )
                Log.d("Juan", "vamos a crear pedido")
                pedidoViewModel.createPedido(pedido)
                dialog.dismiss()
            }
            .setNegativeButton("Cancelar") { dialog, id ->
                dialog.cancel()
            }

        val alert = dialogBuilder.create()
        alert.setTitle("Confirmar Pedido")
        alert.show()
    }
}
