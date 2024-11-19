package com.android.dlddev.progeren2.core.auditorydatabase.di

import android.content.Context
import androidx.room.Room
import com.android.dlddev.progeren2.core.auditorydatabase.AuditoryDatabase
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
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    @Singleton
    @Provides
    fun provideAuditoryDatabase(@ApplicationContext context: Context) = Room
        .databaseBuilder(context, AuditoryDatabase::class.java, "auditory_database")
        .build()

@Provides
fun providesSectionDao(db: AuditoryDatabase): SectionDao = db.getSectionDao()

@Provides
fun providesFindingDao(db: AuditoryDatabase): FindingDao = db.getFindingDao()

@Provides
fun providesEnvironmentDao(db: AuditoryDatabase): EnvironmentDao = db.getEnvironmentDao()

@Provides
fun providesLightingDao(db: AuditoryDatabase): LightingDao = db.getLightingDao()

@Provides
fun providesClimateEquipmentDao(db: AuditoryDatabase): ClimateEquipmentDao = db.getClimateEquipmentDao()

@Provides
fun providesITEquipmentDao(db: AuditoryDatabase): ITEquipmentDao = db.getITEquipmentDao()

@Provides
fun providesDomesticEquipmentDao(db: AuditoryDatabase): DomesticEquipmentDao = db.getDomesticEquipmentDao()

@Provides
fun providesEngineDao(db: AuditoryDatabase): EngineDao = db.getEngineDao()

@Provides
fun providesFaucetDao(db: AuditoryDatabase): FaucetDao = db.getFaucetDao()

@Provides
fun providesToiletDao(db: AuditoryDatabase): ToiletDao = db.getToiletDao()

@Provides
fun providesLandscapingDao(db: AuditoryDatabase): LandscapingDao = db.getLandscapingDao()

@Provides
fun providesUrinalDao(db: AuditoryDatabase): UrinalDao = db.getUrinalDao()

@Provides
fun providesShowerDao(db: AuditoryDatabase): ShowerDao = db.getShowerDao()

}