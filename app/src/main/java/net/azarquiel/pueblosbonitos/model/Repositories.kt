package net.azarquiel.pueblosbonitos.model

import android.app.Application
import androidx.lifecycle.LiveData

class ComunidadRepository(application: Application) {

    val comunidadDao = PueblosBonitos.getDatabase(application)!!.comunidadDao()
    // select
    fun getComunidades(): LiveData<List<Comunidad>> {
        return comunidadDao.getComunidades()
    }
}
class PuebloRepository(application: Application) {

    val puebloDao = PueblosBonitos.getDatabase(application)!!.puebloDao()
    // select
    fun getPueblosByComunidad(idcomunidad:Int): LiveData<List<PuebloWithProvincia>> {
        return puebloDao.getPueblosByComunidad(idcomunidad)
    }
}

