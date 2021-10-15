package com.larissa.gistsapp.data.mapper

import com.larissa.gistsapp.data.api.response.GistDetailsResponse
import com.larissa.gistsapp.data.api.response.GistsResponse
import com.larissa.gistsapp.data.model.Gist
import com.larissa.gistsapp.data.model.GistDetails

class GistsMapper {
    fun mapFromResponseToGist(gistResponseList: List<GistsResponse>): List<Gist> =
        gistResponseList.map {
            Gist(
                ownerId = it.owner.id,
                fileType = it.files.map { file -> file.value.type }.joinToString(),
                ownerLogin = it.owner.login,
                ownerPicture = it.owner.avatar_url,
                isFavorite = it.isFavorite
            )
        }

    fun mapFromResponseToGistDetails(gistDetailsResponseList: GistDetailsResponse): GistDetails =
        GistDetails(
            picture = gistDetailsResponseList.avatar_url,
            bio = gistDetailsResponseList.bio,
            blog = gistDetailsResponseList.blog,
            company = gistDetailsResponseList.company,
            email = gistDetailsResponseList.email,
            id = gistDetailsResponseList.id,
            location = gistDetailsResponseList.location,
            login = gistDetailsResponseList.login,
            name = gistDetailsResponseList.name
        )
}

