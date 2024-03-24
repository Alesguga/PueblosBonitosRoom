package net.azarquiel.pueblosbonitos.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.azarquiel.pueblosbonitos.R
import net.azarquiel.pueblosbonitos.adapters.AdapterComunidad
import net.azarquiel.pueblosbonitos.model.Comunidad
import net.azarquiel.pueblosbonitos.util.Util
import net.azarquiel.pueblosbonitos.viewmodel.ComunidadViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: AdapterComunidad

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Util.inyecta(this, "pueblosbonitos.sqlite")
        initRV()
        getDatos()


    }

    private fun getDatos() {
        val comunidadViewModel = ViewModelProvider(this).get(ComunidadViewModel::class.java)

        comunidadViewModel.getComunidades().observe(this, Observer { comunidades ->
            // Update the cached copy of the products in the adapter.
            comunidades?.let { adapter.setComunidades(it) }
        })

    }

    private fun initRV() {
        val rvcomunidad = findViewById<RecyclerView>(R.id.rvcomunidad)
        adapter = AdapterComunidad(this, R.layout.rowcomunidad)
        rvcomunidad.adapter = adapter
        rvcomunidad.layoutManager = LinearLayoutManager(this)
    }

    fun onclickcomunidad(v: View) {
        val comunidadpulsada = v.tag as Comunidad

        val intent = Intent(this, PueblosActivity::class.java)
        intent.putExtra("comunidad", comunidadpulsada)
        startActivity(intent)
    }
}