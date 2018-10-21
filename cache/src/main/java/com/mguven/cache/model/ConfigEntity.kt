package com.mguven.cache.model

import android.arch.persistence.room.Entity
import com.mguven.cache.db.ConfigConstants

@Entity(tableName = ConfigConstants.TABLE_NAME)
class ConfigEntity(val lastCacheTime: Long) {
}