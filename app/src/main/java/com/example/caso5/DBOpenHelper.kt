package com.example.caso5

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class DBOpenHelper private constructor(context: Context?) :
    SQLiteOpenHelper(context, ComunidadContract.NOMBRE_BD, null, ComunidadContract.VERSION) {
    override fun onCreate(sqLiteDatabase: SQLiteDatabase) {
        try {
            sqLiteDatabase.execSQL(
                "CREATE TABLE ${ComunidadContract.Companion.Entrada.NOMBRE_TABLA}"
                        + "(${ComunidadContract.Companion.Entrada.COLUMNA_ID} INTEGER PRIMARY KEY"
                        + ",${ComunidadContract.Companion.Entrada.COLUMNA_NOMBRE} NVARCHAR(20) NOT NULL"
                        + ",${ComunidadContract.Companion.Entrada.COLUMNA_IMAGEN} INT NOT NULL);"
            )
            // Insertar datos en la tabla
            inicializarBBDD(sqLiteDatabase)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun onUpgrade(sqLiteDatabase: SQLiteDatabase, p1: Int, p2: Int) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS ${ComunidadContract.Companion.Entrada.NOMBRE_TABLA};")
        onCreate(sqLiteDatabase)
    }

    private fun inicializarBBDD(db: SQLiteDatabase) {
        val lista = cargarComunidades()
        for (comunidad in lista) {
            db.execSQL(
                ("INSERT INTO ${ComunidadContract.Companion.Entrada.NOMBRE_TABLA}(" +
                        "${ComunidadContract.Companion.Entrada.COLUMNA_ID}," +
                        "${ComunidadContract.Companion.Entrada.COLUMNA_NOMBRE}," +
                        "${ComunidadContract.Companion.Entrada.COLUMNA_IMAGEN})" +
                        " VALUES (${comunidad.id},'${comunidad.nombre}',${comunidad.imagen});")
            )
        }
    }

    private fun cargarComunidades(): MutableList<Comunidad> {
        return mutableListOf(
            Comunidad(0, "Andalucía", R.drawable.andalucia),
            Comunidad(1, "Aragón", R.drawable.aragon),
            Comunidad(2, "Asturias", R.drawable.asturias),
            Comunidad(3, "Baleares", R.drawable.baleares),
            Comunidad(4, "Canarias", R.drawable.canarias),
            Comunidad(5, "Cantabria", R.drawable.cantabria),
            Comunidad(6, "Castilla y León", R.drawable.castillaleon),
            Comunidad(7, "Castilla la Mancha", R.drawable.castillamancha),
            Comunidad(8, "Cataluña", R.drawable.catalunya),
            Comunidad(9, "Ceuta", R.drawable.ceuta),
            Comunidad(10, "Extremadura", R.drawable.extremadura),
            Comunidad(11, "Galicia", R.drawable.galicia),
            Comunidad(12, "La Rioja", R.drawable.larioja),
            Comunidad(13, "Madrid", R.drawable.madrid),
            Comunidad(14, "Melilla", R.drawable.melilla),
            Comunidad(15, "Murcia", R.drawable.murcia),
            Comunidad(16, "Navarra", R.drawable.navarra),
            Comunidad(17, "País Vasco", R.drawable.paisvasco),
            Comunidad(18, "Valencia", R.drawable.valencia)
        )
    }

    companion object {
        private var dbOpen: DBOpenHelper? = null
        fun getInstance(context: Context?): DBOpenHelper? {
            if (dbOpen == null) dbOpen = DBOpenHelper(context)
            return dbOpen
        }
    }

}
