package com.edwinacubillos.veterinarioapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vaccine_table")
data class Vaccine(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "id_pet") val id_pet: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "dose") val dose: String
)
