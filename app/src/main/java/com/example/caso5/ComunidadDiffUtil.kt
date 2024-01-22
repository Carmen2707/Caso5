package com.example.caso5

import androidx.recyclerview.widget.DiffUtil

class ComunidadDiffUtil(private val oldList:MutableList<Comunidad>, private val newList:MutableList<Comunidad>):DiffUtil.Callback() {
    override fun getOldListSize(): Int =oldList.size


    override fun getNewListSize(): Int =newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id==newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition]==newList[newItemPosition]
    }

}