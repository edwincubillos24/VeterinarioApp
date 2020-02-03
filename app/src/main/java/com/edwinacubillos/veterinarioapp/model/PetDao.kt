package com.edwinacubillos.veterinarioapp.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface PetDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPet(pet: Pet)

    @Query("SELECT * FROM pet_table")
    fun getAllPet(): LiveData<List<Pet>>

    @Query("SELECT * FROM vaccine_table WHERE id_pet LIKE :id_pet")
    fun getPetsVaccines(id_pet: Int): LiveData<List<Vaccine>>

    @Delete
    suspend fun deletePet(pet: Pet)

    @Query("DELETE FROM vaccine_table WHERE id_pet LIKE :id_pet")
    suspend fun deletePetVaccine(id_pet: Int)
}
