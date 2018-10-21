package com.mguven.remote.mapper

import com.mguven.data.model.ProjectEntity
import com.mguven.remote.model.ProjectModel
import javax.inject.Inject

class ProjectsResponseModelMapper @Inject constructor() :
    ModelMapper<ProjectModel, ProjectEntity> {

    override fun mapFromModel(model: ProjectModel): ProjectEntity {
        return ProjectEntity(
            model.id, model.name, model.fullName, model.starCount.toString(),
            model.dateCreated, model.owner.ownerName, model.owner.ownerAvatar
        )
    }


}