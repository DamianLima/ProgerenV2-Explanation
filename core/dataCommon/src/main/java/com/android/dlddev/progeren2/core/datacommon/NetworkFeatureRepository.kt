package com.android.dlddev.progeren2.core.datacommon

import com.android.dlddev.progeren2.core.domain.model.ResponseRes

interface NetworkFeatureRepository<T> {

    suspend fun set(feature: T): ResponseRes<T>

    suspend fun getAllBySede(linked: String): ResponseRes<List<T>>

    suspend fun setAll(features: List<T>): ResponseRes<List<T>>

    suspend fun synchronizedImages(features: List<T>): ResponseRes<List<T>>
}