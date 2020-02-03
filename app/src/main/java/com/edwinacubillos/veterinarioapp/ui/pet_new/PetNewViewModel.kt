package com.edwinacubillos.veterinarioapp.ui.pet_new

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.edwinacubillos.veterinarioapp.data.repository.pet.PetRepositoryImpl
import com.edwinacubillos.veterinarioapp.model.Pet
import com.edwinacubillos.veterinarioapp.model.VeterinarianDataBase
import kotlinx.coroutines.launch

class PetNewViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PetRepositoryImpl

    init {
        val petDao =
            VeterinarianDataBase.getVeterinarianDataBase(application, viewModelScope).petDao()
        repository = PetRepositoryImpl(petDao)
    }

    fun insertPet(pet: Pet) = viewModelScope.launch {
        repository.insertPet(pet)
    }
}
