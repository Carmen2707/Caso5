package com.example.caso5


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
class ActivityDos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2)
        val nombre = intent.getStringExtra("nombre")
        val etNombre = findViewById<EditText>(R.id.etNombre)
        etNombre.hint = nombre

        val imagen = intent.getIntExtra("imagen", 0)
        val ivComunidad = findViewById<ImageView>(R.id.ivComunidad2)
        ivComunidad.setImageResource(imagen)

        val posicion = intent.getIntExtra("posicion", 0)

        val comunidad = lista[posicion]
        val btnCambiar = findViewById<Button>(R.id.btnCambiar)
        btnCambiar.setOnClickListener {


            val intent = Intent()
            val name = etNombre.text.toString()
            miDAO.actualizarNombre(this, comunidad, name)
            intent.putExtra("nombre", name)

            intent.putExtra("posicion", posicion)
            setResult(RESULT_OK, intent)

            finish()
        }
        val btnCancelar = findViewById<Button>(R.id.btnCancelar)
        btnCancelar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}