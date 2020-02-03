package com.edwinacubillos.veterinarioapp.model

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface OwnerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOwner(owner: Owner)

    @Query("SELECT * FROM owner_table")
    fun getAllOwner(): LiveData<List<Owner>>

    @Query("SELECT * FROM pet_table WHERE id_owner LIKE :id_owner")
    fun getOwnerPets(id_owner: Int): LiveData<List<Pet>>

    @Delete
    suspend fun deleteOwner(owner: Owner)

    @Query("DELETE FROM pet_table WHERE id_owner LIKE :id_owner")
    suspend fun deletePetOwner(id_owner: Int)
}
