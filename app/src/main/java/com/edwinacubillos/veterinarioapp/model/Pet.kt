package com.edwinacubillos.veterinarioapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "pet_table")
data class Pet(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "id_owner") val id_owner: Int,
    @ColumnInfo(name = "name") val name: String?,
    @ColumnInfo(name = "age") val age: String?,
    @ColumnInfo(name = "kind") val kind: String?,
    @ColumnInfo(name = "race") val race: String?
) : Serializable
