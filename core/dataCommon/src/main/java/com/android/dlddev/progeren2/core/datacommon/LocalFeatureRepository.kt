package com.android.dlddev.progeren2.core.datacommon

import kotlinx.coroutines.flow.Flow

interface LocalFeatureRepository<T> {

    fun getAllByLinked(linked: String): Flow<List<T>>

    suspend fun getByLinked(linked: String): T?

    suspend fun insertAll(items: List<T>)

    suspend fun set(item: T)

    suspend fun delete(item: T)

    suspend fun getById(id: String): T?
}