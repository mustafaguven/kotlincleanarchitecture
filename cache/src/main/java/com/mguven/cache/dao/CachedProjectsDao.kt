package com.mguven.cache.dao

import android.arch.persistence.room.*
import com.mguven.cache.db.ProjectConstants.DELETE_PROJECTS
import com.mguven.cache.db.ProjectConstants.QUERY_BOOKMARKED_PROJECTS
import com.mguven.cache.db.ProjectConstants.QUERY_PROJECTS
import com.mguven.cache.db.ProjectConstants.QUERY_UPDATE_BOOKMARK_STATUS
import com.mguven.cache.model.CachedProjectEntity
import io.reactivex.Flowable

@Dao
abstract class CachedProjectsDao {

    @Query(QUERY_PROJECTS)
    abstract fun getProjects(): Flowable<List<CachedProjectEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertProjects(project: List<CachedProjectEntity>)

    /*@Query(DELETE_PROJECTS)
    abstract fun deleteProjects()*/

    @Query(QUERY_BOOKMARKED_PROJECTS)
    abstract fun getBookmarkedProjects(): Flowable<List<CachedProjectEntity>>

    @Query(QUERY_UPDATE_BOOKMARK_STATUS)
    abstract fun setBookmarkStatus(
        isBookmarked: Boolean,
        projectId: String
    )


}