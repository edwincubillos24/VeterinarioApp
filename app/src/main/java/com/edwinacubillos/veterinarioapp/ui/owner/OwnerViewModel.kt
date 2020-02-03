package com.edwinacubillos.veterinarioapp.ui.owner

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.edwinacubillos.veterinarioapp.data.repository.owner.OwnerRepositoryImpl
import com.edwinacubillos.veterinarioapp.model.Owner
import com.edwinacubillos.veterinarioapp.model.VeterinarianDataBase
import kotlinx.coroutines.launch

class OwnerViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: OwnerRepositoryImpl

    val allOwner: LiveData<List<Owner>>

    fun deleteOwner(owner: Owner) = viewModelScope.launch {
        repository.deleteOwner(owner)
    }

    fun deletePetOwner(owner_id: Int) = viewModelScope.launch {
        repository.deletePetOwner(owner_id)
    }

    init {
        val ownerDao =
            VeterinarianDataBase.getVeterinarianDataBase(application, viewModelScope).ownerDao()
        repository = OwnerRepositoryImpl(ownerDao)
        allOwner = repository.getAllOwner
    }
}
