package com.edwinacubillos.veterinarioapp.ui.owner_detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.edwinacubillos.veterinarioapp.data.repository.owner.OwnerRepositoryImpl
import com.edwinacubillos.veterinarioapp.model.Pet
import com.edwinacubillos.veterinarioapp.model.VeterinarianDataBase

class OwnerDetailViewModel (application: Application) : AndroidViewModel(application) {

    private val repository: OwnerRepositoryImpl

    fun getOwnerPets(id_owner: Int): LiveData<List<Pet>>{
        return repository.getOwnerPets(id_owner)
    }

    init{
        val ownerDao = VeterinarianDataBase.getVeterinarianDataBase(application, viewModelScope).ownerDao()
        repository = OwnerRepositoryImpl(ownerDao)
    }
}
