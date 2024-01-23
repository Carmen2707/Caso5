package com.example.caso5

data class Comunidad(
    var id: Int, var nombre: String, val imagen: Int, val habitantes: Int,
    val capital: String, val latitud: Double, val longitud: Double, val icono: Int
) {
}