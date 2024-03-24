package net.azarquiel.pueblosbonitos.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Insert
import androidx.room.Delete
import androidx.room.Transaction
import androidx.room.Update

@Dao
interface ComunidadDao {
    @Query("SELECT * from comunidad ORDER BY nombre ASC")
    fun getComunidades(): LiveData<List<Comunidad>>
}
@Dao
interface PuebloDao {
    @Transaction
    @Query("SELECT pu.* from pueblo pu, provincia pro where pu.provincia=pro.id and comunidad=:idcomunidad ORDER BY nombre ASC")
    fun getPueblosByComunidad(idcomunidad:Int): LiveData<List<PuebloWithProvincia>>
}

