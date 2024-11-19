package com.android.dlddev.progeren2.core.auditorydatabase.dao.energy

import androidx.room.Dao
import androidx.room.Query
import com.android.dlddev.progeren2.core.databasecommon.BaseDao
import com.android.dlddev.progeren2.core.auditorydatabase.entity.energy.ClimateEquipmentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ClimateEquipmentDao : BaseDao<ClimateEquipmentEntity> {

    @Query("SELECT ALL * FROM climate_equipment WHERE linked = :linked")
    override fun getAllByLinked(linked: String): Flow<List<ClimateEquipmentEntity>>

    @Query("SELECT * FROM climate_equipment WHERE id = :id")
    override suspend fun getById(id: String): ClimateEquipmentEntity?

    @Query("SELECT * FROM climate_equipment WHERE linked = :linked")
    override suspend fun getByLinked(linked: String): ClimateEquipmentEntity?
}