package com.android.dlddev.progeren2.core.auditorydatabase

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider

object TestDatabase {

    fun createDatabase(): AuditoryDatabase {
        return Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AuditoryDatabase::class.java
        ).allowMainThreadQueries()
            .build()
    }
}