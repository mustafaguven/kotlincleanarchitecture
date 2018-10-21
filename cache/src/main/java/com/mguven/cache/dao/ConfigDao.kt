package com.mguven.cache.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.mguven.cache.db.ConfigConstants
import com.mguven.cache.model.ConfigEntity
import io.reactivex.Flowable

@Dao
abstract class ConfigDao {

    @Query(ConfigConstants.QUERY_CONFIG)
    abstract fun getConfig(): Flowable<ConfigEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertConfig(config: ConfigEntity)


}