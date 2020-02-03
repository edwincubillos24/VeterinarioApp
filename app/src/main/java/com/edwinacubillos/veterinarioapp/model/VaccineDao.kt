package com.edwinacubillos.veterinarioapp.model

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface VaccineDao {

    @Insert
    suspend fun insertVaccine(vaccine: Vaccine)
}
