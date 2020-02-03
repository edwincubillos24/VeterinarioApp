package com.edwinacubillos.veterinarioapp.data.repository.owner

import androidx.lifecycle.LiveData
import com.edwinacubillos.veterinarioapp.model.Owner
import com.edwinacubillos.veterinarioapp.model.OwnerDao
import com.edwinacubillos.veterinarioapp.model.Pet

class OwnerRepositoryImpl(private val ownerDao: OwnerDao) {

    suspend fun insertOwner(owner: Owner) {
        ownerDao.insertOwner(owner)
    }

    val getAllOwner: LiveData<List<Owner>> = ownerDao.getAllOwner()

    fun getOwnerPets(id_owner: Int): LiveData<List<Pet>> {
        return ownerDao.getOwnerPets(id_owner)
    }

    suspend fun deleteOwner(owner: Owner) {
        return ownerDao.deleteOwner(owner)
    }

    suspend fun deletePetOwner(id_owner: Int) {
        return ownerDao.deletePetOwner(id_owner)
    }
}
