package com.example.caso5.adapter

import android.view.ContextMenu
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.caso5.Comunidad
import com.example.caso5.databinding.ItemComunidadBinding

class ComunidadViewHolder(view: View) : RecyclerView.ViewHolder(view),
    View.OnCreateContextMenuListener {
    val binding = ItemComunidadBinding.bind(view)
    private lateinit var comunidad: Comunidad

    fun render(item: Comunidad, onClickListener: (Comunidad) -> Unit) {
        comunidad = item
        binding.tvComunidadNombre.text = item.nombre
        binding.ivComunidad.setImageResource(item.imagen)
        itemView.setOnClickListener {
            onClickListener(item)
        }
        itemView.setOnCreateContextMenuListener(this)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menu!!.setHeaderTitle(comunidad.nombre)
        menu.add(this.adapterPosition, 0, 0, "Eliminar")
        menu.add(this.adapterPosition, 1, 1, "Editar")
        menu.add(this.adapterPosition,2,2,"Ver foto")
    }
}
