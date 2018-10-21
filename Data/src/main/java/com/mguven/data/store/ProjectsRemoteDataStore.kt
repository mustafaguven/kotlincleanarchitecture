package com.mguven.data.store

import com.mguven.data.model.ProjectEntity
import com.mguven.data.repository.ProjectsDataStore
import com.mguven.data.repository.ProjectsRemote
import io.reactivex.Completable
import io.reactivex.Observable
import java.lang.UnsupportedOperationException
import javax.inject.Inject

class ProjectsRemoteDataStore @Inject constructor(
    private val projectsRemote: ProjectsRemote
) : ProjectsDataStore {
    override fun getProjects(): Observable<List<ProjectEntity>> {
        return projectsRemote.getProjects()
    }

    override fun saveProjects(projects: List<ProjectEntity>): Completable {
        throw UnsupportedOperationException("Saving projects isn't supported here...")
    }

    override fun clearProjects(): Completable {
        throw UnsupportedOperationException("Saving projects isn't supported here...")
    }

    override fun getBookmarkedProjects(): Observable<List<ProjectEntity>> {
        throw UnsupportedOperationException("Saving projects isn't supported here...")
    }

    override fun setProjectAsBookmarked(projectId: String): Completable {
        throw UnsupportedOperationException("Saving projects isn't supported here...")
    }

    override fun setProjectAsUnbookmarked(projectId: String): Completable {
        throw UnsupportedOperationException("Saving projects isn't supported here...")
    }
}