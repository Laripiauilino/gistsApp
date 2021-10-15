package com.larissa.gistsapp.domain

import com.larissa.gistsapp.data.repository.FavoriteRepository


class GetFavoritesUseCase (
    private val favoritesRepository: FavoriteRepository = FavoriteRepository()
)
{
     fun execute()  = favoritesRepository.fetchFavoriteGists()
}
