package com.example.feed.ui

import android.app.AlertDialog
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import com.example.feed.R

class NuevoPedidoActivity: ComponentActivity() {
    private lateinit var backButton: ImageButton
    private lateinit var nombreMesero: String
    private lateinit var numeroMesaEditText: EditText
    private lateinit var descripcionEditText: EditText
    private lateinit var confirmarPedidoFrame: FrameLayout
    private lateinit var numeroMesa: String
    private lateinit var descripcionPedido: String

    override fun onCreate(savedInstanceState: Bundle?) {

        // ================ Ui initialization =================== //
        super.onCreate(savedInstanceState)
        setContentView(R.layout.crear_pedido_activity)

        // ================ vars initialization =================== //
        nombreMesero = intent.getStringExtra("user").toString()
        backButton = findViewById(R.id.backButton)
        numeroMesaEditText = findViewById(R.id.editTextText)
        descripcionEditText = findViewById(R.id.editTextText2)
        confirmarPedidoFrame = findViewById(R.id.frame3)

        // ================ back button click listener =================== //
        backButton.setOnClickListener{
            finish()
        }

        // ================ confirmar pedido click listener =================== //
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
                // Acción a realizar al confirmar el pedido
                // Puedes añadir el código para manejar la confirmación del pedido aquí asd
                dialog.dismiss()
            }
            .setNegativeButton("Cancelar") { dialog, id ->
                // Acción a realizar al cancelar
                dialog.cancel()
            }

        val alert = dialogBuilder.create()
        alert.setTitle("Confirmar Pedido")
        alert.show()
    }
}