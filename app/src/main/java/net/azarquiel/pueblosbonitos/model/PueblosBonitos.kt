package net.azarquiel.pueblosbonitos.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Comunidad::class, Provincia::class, Pueblo::class], version = 1)
abstract class PueblosBonitos: RoomDatabase() {
    abstract fun comunidadDao(): ComunidadDao
    abstract fun puebloDao(): PuebloDao
    companion object {
        // Singleton prevents multiple instances of database opening at the same time.
        @Volatile
        private var INSTANCE:  PueblosBonitos? = null

        fun getDatabase(context: Context): PueblosBonitos {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PueblosBonitos::class.java,   "pueblosbonitos.sqlite"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
