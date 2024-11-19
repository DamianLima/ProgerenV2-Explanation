package com.android.dlddev.progeren2.core.databasecommon

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import kotlinx.coroutines.flow.Flow

@Dao
interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun set(item: T)
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<T>)
    @Delete
    suspend fun delete(item: T)
    fun getAllByLinked(linked: String): Flow<List<T>>
    suspend fun getById(id: String): T?
    suspend fun getByLinked(linked: String): T?
}