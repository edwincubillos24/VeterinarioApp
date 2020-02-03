package com.edwinacubillos.veterinarioapp.data.repository.pet

import androidx.lifecycle.LiveData
import com.edwinacubillos.veterinarioapp.model.Pet
import com.edwinacubillos.veterinarioapp.model.PetDao
import com.edwinacubillos.veterinarioapp.model.Vaccine

class PetRepositoryImpl(private val petDao: PetDao) {

    suspend fun insertPet(pet: Pet) {
        petDao.insertPet(pet)
    }

    val getAllPet: LiveData<List<Pet>> = petDao.getAllPet()

    fun getPetsVaccines(id_pet: Int): LiveData<List<Vaccine>> {
        return petDao.getPetsVaccines(id_pet)
    }

    suspend fun deletePet(pet: Pet) {
        return petDao.deletePet(pet)
    }

    suspend fun deletePetVaccine(id_pet: Int) {
        return petDao.deletePetVaccine(id_pet)
    }
}
