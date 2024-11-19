package com.android.dlddev.progeren2.core.auditorydatabase

import androidx.room.Dao
import androidx.room.Database
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Relation
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.android.dlddev.progeren2.core.auditorydatabase.dao.HallazgoDao
import com.android.dlddev.progeren2.core.auditorydatabase.dao.RelationalDao
import com.android.dlddev.progeren2.core.auditorydatabase.dao.SeccionDao
import com.android.dlddev.progeren2.core.auditorydatabase.dao.energy.ClimateEquipmentDao
import com.android.dlddev.progeren2.core.auditorydatabase.dao.energy.DomesticEquipmentDao
import com.android.dlddev.progeren2.core.auditorydatabase.dao.energy.EngineDao
import com.android.dlddev.progeren2.core.auditorydatabase.dao.energy.EnvironmentDao
import com.android.dlddev.progeren2.core.auditorydatabase.dao.energy.ITEquipmentDao
import com.android.dlddev.progeren2.core.auditorydatabase.dao.energy.IlluminationDao
import com.android.dlddev.progeren2.core.auditorydatabase.dao.water.DuchaDao
import com.android.dlddev.progeren2.core.auditorydatabase.dao.water.GriferiaDao
import com.android.dlddev.progeren2.core.auditorydatabase.dao.water.InodoroDao
import com.android.dlddev.progeren2.core.auditorydatabase.dao.water.PaisajismoDao
import com.android.dlddev.progeren2.core.auditorydatabase.dao.water.UrinalDao
import com.android.dlddev.progeren2.core.auditorydatabase.entity.HallazgoEntity
import com.android.dlddev.progeren2.core.auditorydatabase.entity.SeccionEntity
import com.android.dlddev.progeren2.core.auditorydatabase.entity.energy.ClimateEquipmentEntity
import com.android.dlddev.progeren2.core.auditorydatabase.entity.energy.DomesticEquipmentEntity
import com.android.dlddev.progeren2.core.auditorydatabase.entity.energy.EngineEntity
import com.android.dlddev.progeren2.core.auditorydatabase.entity.energy.EnvironmentEntity
import com.android.dlddev.progeren2.core.auditorydatabase.entity.energy.ITEquipmentEntity
import com.android.dlddev.progeren2.core.auditorydatabase.entity.energy.IlluminationEntity
import com.android.dlddev.progeren2.core.auditorydatabase.entity.water.DuchaEntity
import com.android.dlddev.progeren2.core.auditorydatabase.entity.water.GriferiaEntity
import com.android.dlddev.progeren2.core.auditorydatabase.entity.water.InodoroEntity
import com.android.dlddev.progeren2.core.auditorydatabase.entity.water.PaisajismoEntity
import com.android.dlddev.progeren2.core.auditorydatabase.entity.water.UrinalEntity
import com.android.dlddev.progeren2.core.databasecommon.PhotoModelConverter


@Database(
    [
        SectionEntity::class,
        FindingEntity::class,

        EnvironmentEntity::class,
        LightingEntity::class,
        ITEquipmentEntity::class,
        ClimateEquipmentEntity::class,
        DomesticEquipmentEntity::class,
        EngineEntity::class,

        FaucetEntity::class,
        ToiletEntity::class,
        LandscapingEntity::class,
        UrinalEntity::class,
        ShowerEntity::class,
    ], version = 1, exportSchema = true
)
@TypeConverters(PhotoModelConverter::class)
abstract class AuditDatabase : RoomDatabase() {

    abstract fun getSectionDao(): SectionDao
    abstract fun getFindingDao(): FindingDao

    abstract fun getEnvironmentDao(): EnvironmentDao
    abstract fun getLightingDao(): LightingDao
    abstract fun getITEquipmentDao(): ITEquipmentDao
    abstract fun getClimateEquipmentDao(): ClimateEquipmentDao
    abstract fun getDomesticEquipmentDao(): DomesticEquipmentDao
    abstract fun getEngineDao(): EngineDao

    abstract fun getShowerDao(): ShowerDao
    abstract fun getFaucetDao(): FaucetDao
    abstract fun getToiletDao(): ToiletDao
    abstract fun getUrinalDao(): UrinalDao
    abstract fun getLandscapingDao(): LandscapingDao
}