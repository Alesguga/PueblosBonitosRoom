package net.azarquiel.pueblosbonitos.view

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import net.azarquiel.pueblosbonitos.R
import net.azarquiel.pueblosbonitos.adapters.AdapterComunidad
import net.azarquiel.pueblosbonitos.adapters.AdapterPueblo
import net.azarquiel.pueblosbonitos.databinding.ActivityPueblosBinding
import net.azarquiel.pueblosbonitos.model.Comunidad
import net.azarquiel.pueblosbonitos.viewmodel.ComunidadViewModel
import net.azarquiel.pueblosbonitos.viewmodel.PuebloViewModel

class PueblosActivity : AppCompatActivity() {

    private lateinit var adapter: AdapterPueblo
    private lateinit var comunidad: Comunidad
    private lateinit var binding: ActivityPueblosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPueblosBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        comunidad = intent.getSerializableExtra("comunidad") as Comunidad
        initRV()
        getDatos()

        binding.fab.setOnClickListener { view ->

        }
    }

    private fun getDatos() {
        val puebloViewModel = ViewModelProvider(this).get(PuebloViewModel::class.java)

        puebloViewModel.getPueblosByComunidad(comunidad.id).observe(this, Observer { pueblos ->
            // Update the cached copy of the products in the adapter.
            pueblos?.let {
                adapter.setPueblos(it)
            }
        })
    }
    private fun initRV() {
        adapter = AdapterPueblo(this, R.layout.rowpueblo)
        binding.cp.rvpueblo.adapter = adapter
        binding.cp.rvpueblo.layoutManager = LinearLayoutManager(this)
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_pueblos, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                // pulsaron sobre settings...

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}