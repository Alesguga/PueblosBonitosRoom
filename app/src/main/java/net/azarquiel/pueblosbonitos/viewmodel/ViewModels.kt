package net.azarquiel.pueblosbonitos.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import net.azarquiel.pueblosbonitos.model.Comunidad
import net.azarquiel.pueblosbonitos.model.ComunidadRepository
import net.azarquiel.pueblosbonitos.model.PuebloRepository
import net.azarquiel.pueblosbonitos.model.PuebloWithProvincia

class ComunidadViewModel (application: Application) : AndroidViewModel(application) {

    private var repository: ComunidadRepository = ComunidadRepository(application)

    fun getComunidades(): LiveData<List<Comunidad>>{
        return repository.getComunidades()
    }

}
class PuebloViewModel (application: Application) : AndroidViewModel(application) {

    private var repository: PuebloRepository = PuebloRepository(application)

    fun getPueblosByComunidad(idcomunidad:Int): LiveData<List<PuebloWithProvincia>>{
        return repository.getPueblosByComunidad(idcomunidad)
    }

}