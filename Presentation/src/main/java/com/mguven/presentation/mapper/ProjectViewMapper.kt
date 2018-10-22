package com.mguven.presentation.mapper

import com.mguven.domain.model.Project
import com.mguven.presentation.model.ProjectView
import javax.inject.Inject

class ProjectViewMapper @Inject constructor() : IViewMapper<ProjectView, Project> {

    override fun mapToView(type: Project): ProjectView {
        return ProjectView(
            type.id, type.name, type.fullName, type.starCount, type.dateCreated,
            type.ownerName, type.ownerAvatar, type.isBookmarked
        )
    }
}