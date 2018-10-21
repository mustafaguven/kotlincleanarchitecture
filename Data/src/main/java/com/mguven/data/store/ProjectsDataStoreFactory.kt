package com.mguven.data.store

import com.mguven.data.repository.ProjectsDataStore
import javax.inject.Inject

open class ProjectsDataStoreFactory @Inject constructor(
    private val projectsCacheDataStore: ProjectsCacheDataStore,
    private val projectsRemoteDataStore: ProjectsRemoteDataStore
) {

    open fun getDataStore(projectsCached: Boolean, cacheExpired: Boolean)
            : ProjectsDataStore {
        return if (projectsCached && !cacheExpired) {
            projectsCacheDataStore
        } else {
            projectsRemoteDataStore
        }
    }

    // some features like bookmarking / unbookmarking project
    // can be made on only cachedatastore so we want to use it individually
    open fun getCacheDataStore(): ProjectsDataStore{
        return projectsCacheDataStore
    }

}