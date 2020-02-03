package com.edwinacubillos.veterinarioapp.ui.VaccineActivity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.edwinacubillos.veterinarioapp.model.Vaccine
import com.edwinacubillos.veterinarioapp.model.VeterinarianDataBase
import com.edwinacubillos.veterinarioapp.data.repository.vaccine.VaccineRepositoryImpl
import kotlinx.coroutines.launch

class VaccineViewModel(application: Application) : AndroidViewModel(application)  {

    private val repository: VaccineRepositoryImpl

    init {
        val vaccineDao = VeterinarianDataBase.getVeterinarianDataBase(application, viewModelScope).vaccineDao()
        repository = VaccineRepositoryImpl(vaccineDao)
    }

    fun saveVaccine(vaccine: Vaccine) = viewModelScope.launch{
        repository.insertVaccine(vaccine)
    }
}