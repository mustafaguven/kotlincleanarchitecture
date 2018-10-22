package com.mguven.cache.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.mguven.cache.db.ConfigConstants

@Entity(tableName = ConfigConstants.TABLE_NAME)
class ConfigEntity(
    @PrimaryKey
    val lastCacheTime: Long
)