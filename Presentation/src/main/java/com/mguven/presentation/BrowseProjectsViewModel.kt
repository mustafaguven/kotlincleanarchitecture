package com.mguven.presentation

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.mguven.domain.interactor.bookmark.BookmarkProject
import com.mguven.domain.interactor.bookmark.UnbookmarkProject
import com.mguven.domain.interactor.browse.GetProjects
import com.mguven.domain.model.Project
import com.mguven.presentation.mapper.ProjectViewMapper
import com.mguven.presentation.model.ProjectView
import com.mguven.presentation.state.Resource
import com.mguven.presentation.state.ResourceState
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class BrowseProjectsViewModel @Inject constructor(
    private val getProjects: GetProjects,
    private val bookmarkProject: BookmarkProject,
    private val unbookmarkProject: UnbookmarkProject,
    private val mapper: ProjectViewMapper
) : ViewModel() {

    private val liveData: MutableLiveData<Resource<List<ProjectView>>> = MutableLiveData()


    override fun onCleared() {
        getProjects.dispose()
        super.onCleared()
    }

    fun getProjects(): LiveData<Resource<List<ProjectView>>> {
        return liveData
    }

    fun fetchProjects() {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        return getProjects.execute(ProjectsSubscriber())
    }

    fun bookmarkProject(projectId: String) {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        return bookmarkProject.execute(
            BookmarksSubscriber(),
            BookmarkProject.Params.forProject(projectId)
        )
    }

    fun unbookmarkProject(projectId: String) {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        return unbookmarkProject.execute(
            UnbookmarksSubscriber(),
            UnbookmarkProject.Params.forProject(projectId)
        )
    }

    inner class ProjectsSubscriber : DisposableObserver<List<Project>>() {
        override fun onComplete() {
            //do nothing
        }

        override fun onNext(t: List<Project>) {
            liveData.postValue(
                Resource(
                    ResourceState.SUCCESS,
                    t.map {
                        mapper.mapToView(it)
                    }, null
                )
            )
        }

        override fun onError(e: Throwable) {
            liveData.postValue(Resource(ResourceState.ERROR, null, e.localizedMessage))
        }
    }

    inner class BookmarksSubscriber : DisposableCompletableObserver() {
        override fun onComplete() {
            liveData.postValue(
                Resource(
                    ResourceState.SUCCESS,
                    liveData.value?.data, null
                )
            )
        }

        override fun onError(e: Throwable) {
            liveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    liveData.value?.data, e.localizedMessage
                )
            )
        }

    }

    inner class UnbookmarksSubscriber : DisposableCompletableObserver() {
        override fun onComplete() {
            liveData.postValue(
                Resource(
                    ResourceState.SUCCESS,
                    liveData.value?.data, null
                )
            )
        }

        override fun onError(e: Throwable) {
            liveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    liveData.value?.data, e.localizedMessage
                )
            )
        }

    }

}