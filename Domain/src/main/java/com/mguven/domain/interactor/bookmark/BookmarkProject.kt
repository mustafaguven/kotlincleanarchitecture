package com.mguven.domain.interactor.bookmark

import com.mguven.domain.executor.PostExecutionThread
import com.mguven.domain.interactor.CompletableUseCase
import com.mguven.domain.repository.ProjectsRepository
import io.reactivex.Completable
import java.lang.IllegalArgumentException
import javax.inject.Inject

class BookmarkProject @Inject constructor(
    private val projectsRepository: ProjectsRepository,
    postExecutionThread: PostExecutionThread
) : CompletableUseCase<BookmarkProject.Params>(postExecutionThread) {

    data class Params constructor(val projectId: String){
        companion object {
            fun forProject(projectId: String): Params {
                return Params(projectId)
            }
        }
    }

    override fun buildUseCaseCompletable(params: Params?): Completable {
        if(params == null) throw IllegalArgumentException("Params can't be null!")
        return projectsRepository.bookmarkProject(params.projectId)
    }


}