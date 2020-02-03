package com.edwinacubillos.veterinarioapp.ui.pet_detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.edwinacubillos.veterinarioapp.data.repository.pet.PetRepositoryImpl
import com.edwinacubillos.veterinarioapp.model.Vaccine
import com.edwinacubillos.veterinarioapp.model.VeterinarianDataBase

class PetDetailViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: PetRepositoryImpl

    fun getPetVaccines(id_pet: Int): LiveData<List<Vaccine>> {
        return repository.getPetsVaccines(id_pet)
    }

    init {
        val petDao =
            VeterinarianDataBase.getVeterinarianDataBase(application, viewModelScope).petDao()
        repository = PetRepositoryImpl(petDao)
    }
}
