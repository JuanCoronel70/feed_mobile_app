// PedidosAdapter.kt
package com.example.feed.ui

import android.view.LayoutInflater
import android.view.View
import java.text.SimpleDateFormat
import java.util.*
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.feed.R

import com.example.feed.model.PedidoObtain

class PedidosAdapter : ListAdapter<PedidoObtain, PedidosAdapter.PedidoViewHolder>(PedidoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PedidoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pedido, parent, false)
        return PedidoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PedidoViewHolder, position: Int) {
        val pedido = getItem(position)
        holder.bind(pedido)
    }

    class PedidoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val mesaTextView: TextView = itemView.findViewById(R.id.mesaTextView)
        private val detalleTextView: TextView = itemView.findViewById(R.id.detalleTextView)
        private val estadoTextView: TextView = itemView.findViewById(R.id.estadoTextView)
        private val meseroTextView: TextView = itemView.findViewById(R.id.meseroTextView)
        private val horaTextView: TextView = itemView.findViewById(R.id.horaTextView)

        fun bind(pedido: PedidoObtain) {
            mesaTextView.text = "N° Mesa:\n${pedido.mesa}"
            detalleTextView.text = pedido.detalle
            estadoTextView.text = "Estado: ${pedido.estado}"
            meseroTextView.text = "Pedido de ${pedido.mesero}"

            // Convertir el string createdAt a un objeto Date
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
            sdf.timeZone = TimeZone.getTimeZone("UTC") // Indicar la zona horaria UTC para que coincida con el formato de la fecha
            val date = sdf.parse(pedido.createdAt)

            // Formatear el objeto Date para obtener solo la hora
            val horaFormato = SimpleDateFormat("HH:mm", Locale.getDefault())
            horaFormato.timeZone = TimeZone.getDefault() // Indicar la zona horaria local

            // Mostrar la hora formateada en el TextView
            horaTextView.text = "Hora creación pedido:\n${horaFormato.format(date)}"
        }
    }

    class PedidoDiffCallback : DiffUtil.ItemCallback<PedidoObtain>() {
        override fun areItemsTheSame(oldItem: PedidoObtain, newItem: PedidoObtain): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PedidoObtain, newItem: PedidoObtain): Boolean {
            return oldItem == newItem
        }
    }
}
