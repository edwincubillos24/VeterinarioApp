package com.edwinacubillos.veterinarioapp.ui.owner_new

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.edwinacubillos.veterinarioapp.data.repository.owner.OwnerRepositoryImpl
import com.edwinacubillos.veterinarioapp.model.Owner
import com.edwinacubillos.veterinarioapp.model.VeterinarianDataBase
import kotlinx.coroutines.launch

class OwnerNewViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: OwnerRepositoryImpl

    fun insertOwner(owner: Owner) = viewModelScope.launch {
        repository.insertOwner(owner)
    }

    init {
        val ownerDao =
            VeterinarianDataBase.getVeterinarianDataBase(application, viewModelScope).ownerDao()
        repository = OwnerRepositoryImpl(ownerDao)
    }
}
