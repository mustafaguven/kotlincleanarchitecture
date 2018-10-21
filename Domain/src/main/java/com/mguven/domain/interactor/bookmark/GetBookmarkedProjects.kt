package com.mguven.domain.interactor.bookmark

import com.mguven.domain.executor.PostExecutionThread
import com.mguven.domain.interactor.ObservableUseCase
import com.mguven.domain.model.Project
import com.mguven.domain.repository.ProjectsRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetBookmarkedProjects @Inject constructor(
    private val projectsRepository: ProjectsRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<List<Project>, Nothing>(postExecutionThread){

    override fun buildUseCaseObservable(params: Nothing?): Observable<List<Project>> {
        return projectsRepository.getBookmarkedProjects()
    }
}