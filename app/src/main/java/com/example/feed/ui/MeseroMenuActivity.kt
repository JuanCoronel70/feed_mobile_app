package com.example.feed.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.example.feed.R


class MeseroMenuActivity: ComponentActivity() {
    private lateinit var nombreMesero: String
    private lateinit var nombreMeseroTextView: TextView
    private lateinit var crearPedidoButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {

        // ================ Ui initialization =================== //
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mesero_menu_activity)

        // ================ vars initialization =================== //
        nombreMesero = intent.getStringExtra("user").toString()
        nombreMeseroTextView = findViewById(R.id.nombreMesero)
        nombreMeseroTextView.text = nombreMesero
        crearPedidoButton = findViewById(R.id.crearPedido)

        // ================ Crear Pedido Button Handler =================== //
        crearPedidoButton.setOnClickListener{
            val intent = Intent(this, NuevoPedidoActivity::class.java)
            intent.putExtra("user", nombreMesero)
            startActivity(intent)
        }




    }


}