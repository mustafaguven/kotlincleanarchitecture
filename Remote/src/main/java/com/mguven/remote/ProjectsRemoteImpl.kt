package com.mguven.remote

import com.mguven.data.model.ProjectEntity
import com.mguven.data.repository.ProjectsRemote
import com.mguven.remote.mapper.ProjectsResponseModelMapper
import com.mguven.remote.service.GithubTrendingService
import io.reactivex.Observable
import javax.inject.Inject

class ProjectsRemoteImpl @Inject constructor(
    private val service: GithubTrendingService,
    private val mapper: ProjectsResponseModelMapper) : ProjectsRemote {

    override fun getProjects(): Observable<List<ProjectEntity>> {
        return service.searchRepositories(
            "language:kotlin",
            "stars", "desc"
        )
            .map {
                it.items.map {
                    mapper.mapFromModel(it)
                }
            }
    }
}