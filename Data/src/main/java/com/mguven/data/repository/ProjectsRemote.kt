package com.mguven.data.repository

import com.mguven.data.model.ProjectEntity
import io.reactivex.Observable


interface ProjectsRemote {

    fun getProjects() : Observable<List<ProjectEntity>>

}