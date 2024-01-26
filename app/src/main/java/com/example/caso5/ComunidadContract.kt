package com.example.caso5

import android.provider.BaseColumns

class ComunidadContract {
    companion object {
        val NOMBRE_BD = "comunidades"
        val VERSION = 1

        class Entrada : BaseColumns {
            companion object {
                val NOMBRE_TABLA = "comunidades"
                val COLUMNA_ID = "id"
                val COLUMNA_NOMBRE = "nombre"
                val COLUMNA_IMAGEN = "imagen"
                val COLUMNA_HABITANTES = "habitantes"
                val COLUMNA_CAPITAL = "capital"
                val COLUMNA_LATITUD = "latitud"
                val COLUMNA_LONGITUD = "longitud"
                val COLUMNA_ICONO = "icono"
                val COLUMNA_URI = "uri"
            }

        }
    }
}