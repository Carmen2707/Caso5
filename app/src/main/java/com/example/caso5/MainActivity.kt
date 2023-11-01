package com.example.caso5

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
//import com.example.caso5.ComunidadProvider.Companion.listaComunidad
import com.example.caso5.adapter.ComunidadAdapter
import com.example.caso5.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

lateinit var miDAO: ComunidadDAO
lateinit var lista: MutableList<Comunidad>
private lateinit var binding: ActivityMainBinding
private lateinit var adapter: ComunidadAdapter
private lateinit var layoutManager: RecyclerView.LayoutManager

class MainActivity : AppCompatActivity() {

    //iniciamos los datos de la nueva activity
    private lateinit var intentLaunch: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        miDAO = ComunidadDAO()
        lista = miDAO.cargarLista(this)
        layoutManager = LinearLayoutManager(this)
        binding.rvComunidades.layoutManager = layoutManager
        adapter = ComunidadAdapter(lista) { comunidad ->
            onItemSelected(comunidad)

        }
        binding.rvComunidades.adapter = adapter
        binding.rvComunidades.setHasFixedSize(true)

        //iniciar la segunda actividad
        intentLaunch = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        )
        { result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {

                val posicion = result.data?.extras?.getInt("posicion", 0)
                lista[posicion!!].nombre = result.data?.extras?.getString("nombre").toString()
                adapter.notifyItemChanged(posicion)
            }

        }
    }


    private fun onItemSelected(comunidad: Comunidad) {
        Toast.makeText(this, "Yo soy de ${comunidad.nombre}", Toast.LENGTH_SHORT).show()
    }

    //menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.Recargar -> {
                recargar()
                true
            }

            R.id.Limpiar -> {
                limpiar()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
    private fun recargar() {
        lista.clear()
        lista.addAll(miDAO.cargarLista(this))
        adapter.notifyDataSetChanged()
    }

    private fun limpiar() {
        lista.clear()
        adapter.notifyDataSetChanged()
    }

    //al pulsar sobre una comunidad
    override fun onContextItemSelected(item: MenuItem): Boolean {
        var comunidadAfectada: Comunidad = lista[item.groupId]
        when (item.itemId) {
            0 -> {
                val alert =
                    AlertDialog.Builder(this).setTitle("Eliminar ${comunidadAfectada.nombre}")
                        .setMessage("Estas seguro de que quieres eliminar ${comunidadAfectada.nombre}")
                        .setNeutralButton("Cerrar", null).setPositiveButton("Aceptar")
                        { _, _ ->

                            miDAO.eliminarComunidad(this, comunidadAfectada)
                            lista.remove(comunidadAfectada)
                            display("Se ha eliminado ${comunidadAfectada.nombre}")
                            adapter.notifyItemRemoved(item.groupId)
                            adapter.notifyItemRangeChanged(item.groupId, lista.size)


                        }.create()
                alert.show()
            }

            1 -> {
                val intent = Intent(this, ActivityDos::class.java)
                val data = Intent()
                val comunidadPosition = item.groupId
                val comunidad = lista[comunidadPosition]
                intent.putExtra("nombre", comunidad.nombre)
                intent.putExtra("imagen", comunidad.imagen)
                intent.putExtra("posicion", item.groupId)
                intentLaunch.launch(intent)
                val name = data.getStringExtra("nombre")
                if (name != null) {
                    miDAO.actualizarNombre(this, comunidad, name)
                }
            }

            else -> return super.onContextItemSelected(item)
        }

        return true

    }

    private fun display(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_SHORT).show()
    }

}