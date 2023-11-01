package com.example.caso5

import android.content.ContentValues
import android.content.Context
import android.database.Cursor


class ComunidadDAO {
    fun cargarLista(context: Context?): MutableList<Comunidad> {
        lateinit var res: MutableList<Comunidad>
        lateinit var c: Cursor
        try {
            // Obtener acceso de solo lectura
            val db = DBOpenHelper.getInstance(context)!!.readableDatabase
            val sql = "SELECT * FROM comunidades;"
            c = db.rawQuery(sql, null)

            val columnas = arrayOf(
                ComunidadContract.Companion.Entrada.COLUMNA_ID,
                ComunidadContract.Companion.Entrada.COLUMNA_NOMBRE,
                ComunidadContract.Companion.Entrada.COLUMNA_IMAGEN
            )

            c = db.query(
                ComunidadContract.Companion.Entrada.NOMBRE_TABLA,
                columnas, null, null, null, null, null
            )
            res = mutableListOf()
            // Leer resultados del cursor e insertarlos en la lista
            while (c.moveToNext()) {
                val nueva = Comunidad(c.getInt(0), c.getString(1), c.getInt(2))
                res.add(nueva)
            }
        } finally {
            c.close()
        }
        return res
    }

    fun actualizarNombre(context: Context?, comunidad: Comunidad, name: String) {
        val db = DBOpenHelper.getInstance(context)!!.writableDatabase
        /* db.execSQL(
             "UPDATE ${ComunidadContract.Companion.Entrada.NOMBRE_TABLA} " +
                     "SET ${ComunidadContract.Companion.Entrada.COLUMNA_NOMBRE} = '$name', " +
                     "${ComunidadContract.Companion.Entrada.COLUMNA_IMAGEN} = ${comunidad.imagen} " +
                     "WHERE ${ComunidadContract.Companion.Entrada.COLUMNA_ID} = ${comunidad.id};"

         )*/
        val values = ContentValues()
        values.put(ComunidadContract.Companion.Entrada.COLUMNA_ID, comunidad.id)
        values.put(ComunidadContract.Companion.Entrada.COLUMNA_NOMBRE, name)
        values.put(ComunidadContract.Companion.Entrada.COLUMNA_IMAGEN, comunidad.imagen)

        db.update(
            ComunidadContract.Companion.Entrada.NOMBRE_TABLA,
            values,
            "id=?",
            arrayOf(comunidad.id.toString())
        )
        db.close()
    }

    fun eliminarComunidad(context: Context?, comunidad: Comunidad) {
        val db = DBOpenHelper.getInstance(context)!!.writableDatabase
        try {
            db?.delete(
                ComunidadContract.Companion.Entrada.NOMBRE_TABLA,
                "${ComunidadContract.Companion.Entrada.COLUMNA_ID}=?",
                arrayOf(comunidad.id.toString())
            )
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            db?.close()
        }

    }


}
