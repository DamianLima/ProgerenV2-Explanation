package com.android.dlddev.progeren2.core.databasecommon

import androidx.room.TypeConverter
import com.android.dlddev.progeren2.core.domain.model.PhotoModel
import com.android.dlddev.progeren2.core.domain.other.Constants.DIVISOR_PHOTO_COMMENT
import com.android.dlddev.progeren2.core.domain.other.Constants.DIVISOR_PHOTO_OFFLINE_ONLINE
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.net.URLDecoder

class PhotoModelConverter {

    private val gson = Gson()

    @TypeConverter
    fun fromPhotoModelList(photos: List<PhotoModel>?): String {
        return gson.toJson(photos)
    }

    @TypeConverter
    fun toPhotoModelList(photosJson: String?): List<PhotoModel>? {
        if (photosJson == null) return emptyList()
        val listType = object : TypeToken<List<PhotoModel>>() {}.type
        return gson.fromJson<List<PhotoModel>?>(photosJson, listType)
    }
}