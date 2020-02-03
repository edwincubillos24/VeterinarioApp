package com.edwinacubillos.veterinarioapp.ui.pet

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.edwinacubillos.veterinarioapp.data.repository.pet.PetRepositoryImpl
import com.edwinacubillos.veterinarioapp.model.Pet
import com.edwinacubillos.veterinarioapp.model.VeterinarianDataBase
import kotlinx.coroutines.launch

class PetViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PetRepositoryImpl

    val allPet: LiveData<List<Pet>>

    fun deletePet(pet: Pet) = viewModelScope.launch {
        repository.deletePet(pet)
    }

    fun deletePetVaccine(pet_id: Int) = viewModelScope.launch {
        repository.deletePetVaccine(pet_id)
    }

    init {
        val petDao =
            VeterinarianDataBase.getVeterinarianDataBase(application, viewModelScope).petDao()
        repository = PetRepositoryImpl(petDao)
        allPet = repository.getAllPet
    }
}
