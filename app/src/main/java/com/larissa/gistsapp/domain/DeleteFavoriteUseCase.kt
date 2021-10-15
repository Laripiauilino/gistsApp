package com.larissa.gistsapp.domain

import com.larissa.gistsapp.data.model.Gist
import com.larissa.gistsapp.data.repository.FavoriteRepository

class DeleteFavoriteUseCase (
    private val favoritesRepository: FavoriteRepository = FavoriteRepository()
)
{
    fun execute(favoriteGist: Gist) = favoritesRepository.deleteFavoriteGist(favoriteGist)
}