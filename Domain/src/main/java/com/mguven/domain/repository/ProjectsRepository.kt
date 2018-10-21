package com.mguven.domain.repository

import com.mguven.domain.model.Project
import io.reactivex.Completable
import io.reactivex.Observable

// abstracted access point for outside data layers

interface ProjectsRepository {

    fun getProjects(): Observable<List<Project>>

    fun bookmarkProject(projectId: String): Completable

    fun unbookmarkProject(projectId: String): Completable

    fun getBookmarkedProjects(): Observable<List<Project>>

}