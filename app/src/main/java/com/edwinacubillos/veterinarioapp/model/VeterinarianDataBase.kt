package com.edwinacubillos.veterinarioapp.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.edwinacubillos.veterinarioapp.utils.Constants
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Owner::class, Pet::class, Vaccine::class], version = Constants.ONE)
abstract class VeterinarianDataBase : RoomDatabase() {

    abstract fun ownerDao(): OwnerDao
    abstract fun petDao(): PetDao
    abstract fun vaccineDao(): VaccineDao

    private class VeterinarianDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                }
            }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: VeterinarianDataBase? = null

        fun getVeterinarianDataBase(
            context: Context,
            scope: CoroutineScope
        ): VeterinarianDataBase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VeterinarianDataBase::class.java,
                    Constants.DATABASE_NAME
                )
                    .addCallback(VeterinarianDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}
