package com.example.feed.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.feed.R

class LoginActivity: ComponentActivity() {
    private lateinit var nombreText: EditText
    private lateinit var okButton: Button
    private lateinit var nombre: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        nombreText = findViewById(R.id.nameEditText)
        okButton = findViewById(R.id.confirmButton)

        okButton.setOnClickListener{
            nombre = nombreText.text.toString()
            val warningToast = Toast.makeText(this, "Debes ingresar un nombre", Toast.LENGTH_LONG)

            if (nombre.length < 3){

                warningToast.show()

            }
            else {
                intent = Intent(this, MeseroMenuActivity::class.java)
                intent.putExtra("user", nombre)
                startActivity(intent)
            }
        }


    }
}