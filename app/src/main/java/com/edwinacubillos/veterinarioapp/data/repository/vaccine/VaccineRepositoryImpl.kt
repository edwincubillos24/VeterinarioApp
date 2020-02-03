package com.edwinacubillos.veterinarioapp.data.repository.vaccine

import com.edwinacubillos.veterinarioapp.model.Vaccine
import com.edwinacubillos.veterinarioapp.model.VaccineDao

class VaccineRepositoryImpl(private val vaccineDao: VaccineDao) {

    suspend fun insertVaccine(vaccine: Vaccine) {
        vaccineDao.insertVaccine(vaccine)
    }
}
