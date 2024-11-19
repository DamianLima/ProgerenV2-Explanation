package com.android.dlddev.progeren2.core.data.feature.repository

import com.android.dlddev.progeren2.core.databasecommon.BaseDao
import com.android.dlddev.progeren2.core.datacommon.LocalFeatureRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class LocalFeatureRepositoryImpl<T, D : BaseDao<T>, M>(
    private val dao: D,
    private val toDomain: (T) -> M,
    private val toDatabase: (M) -> T
) : LocalFeatureRepository<M> {

    override fun getAllByLinked(linked: String): Flow<List<M>> {
        return dao.getAllByLinked(linked).map { list ->
            list.map { toDomain(it) }
        }
    }

    override suspend fun insertAll(items: List<M>) {
        items.forEach { set(it) }
    }

    override suspend fun set(item: M) {
        dao.set(toDatabase(item))
    }

    override suspend fun delete(item: M) {
        dao.delete(toDatabase(item))
    }

    override suspend fun getByLinked(linked: String): M? {
        return dao.getByLinked(linked)?.let { toDomain(it) }
    }

    override suspend fun getById(id: String): M? {
        return dao.getById(id)?.let { toDomain(it) }
    }
}
