package com.android.dlddev.progeren2.core.auditorydatabase.entity.energy

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.android.dlddev.progeren2.core.domain.model.PhotoModel

@Entity(tableName = "climate_equipment")
data class ClimateEquipmentEntity(
    @PrimaryKey val id: String,
    val linked: String,
    val name: String,
    val type: String,
    val isOnline: Boolean,
    val power: Double,
    val powerCapacity: Double,
    val quantity: Int,
    val cop: Double,
    val status: String,
    val comment: String,
    val photos: List<PhotoModel>,
    val auditor: String,
    val timeStamp: Long
)

