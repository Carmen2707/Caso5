package com.example.caso5.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.caso5.Comunidad
import com.example.caso5.ComunidadDiffUtil
import com.example.caso5.R

class ComunidadAdapter(
    private var ComunidadLista: List<Comunidad>,
    private val onClickListener: (Comunidad) -> Unit
) : RecyclerView.Adapter<ComunidadViewHolder>() {

    fun updateList(newList: List<Comunidad>){
        val comunidadDiff=ComunidadDiffUtil(ComunidadLista,newList)
        val result=DiffUtil.calculateDiff(comunidadDiff)
        ComunidadLista=newList
        result.dispatchUpdatesTo(this)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComunidadViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ComunidadViewHolder(layoutInflater.inflate(R.layout.item_comunidad, parent, false))
    }

    override fun getItemCount(): Int {
        return ComunidadLista.size

    }

    override fun onBindViewHolder(holder: ComunidadViewHolder, position: Int) {
        val item = ComunidadLista[position]
        holder.render(item, onClickListener)
    }

}