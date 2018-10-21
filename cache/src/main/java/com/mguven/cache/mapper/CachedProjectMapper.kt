package com.mguven.cache.mapper

import com.mguven.cache.model.CachedProjectEntity
import com.mguven.data.model.ProjectEntity

class CachedProjectMapper : CacheMapper<CachedProjectEntity, ProjectEntity> {
    override fun mapFromCached(type: CachedProjectEntity): ProjectEntity {
        return ProjectEntity(
            type.id, type.name, type.fullName, type.starCount,
            type.dateCreated, type.ownerName, type.ownerAvatar, type.isBookmarked
        )
    }

    override fun mapToCached(type: ProjectEntity): CachedProjectEntity {
        return CachedProjectEntity(
            type.id, type.name, type.fullName, type.starCount,
            type.dateCreated, type.ownerName, type.ownerAvatar, type.isBookmarked
        )
    }
}