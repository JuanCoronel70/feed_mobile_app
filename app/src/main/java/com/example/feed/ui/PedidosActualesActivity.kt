package com.example.feed.ui

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import com.example.feed.R

class PedidosActualesActivity: ComponentActivity() {

    private lateinit var backButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {

        // ================ Ui initialization =================== //
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ver_pedidos_activity)

        // ================ vars initialization =================== //
        backButton = findViewById(R.id.backButton)
        backButton.setOnClickListener{
            finish()
        }

    }
}