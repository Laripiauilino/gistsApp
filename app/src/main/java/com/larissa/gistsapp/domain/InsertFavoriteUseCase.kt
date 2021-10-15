package com.larissa.gistsapp.domain

import com.larissa.gistsapp.data.repository.FavoriteRepository
import com.larissa.gistsapp.data.model.Gist

class InsertFavoriteUseCase(private val favoritesRepository: FavoriteRepository = FavoriteRepository())
 { fun execute(favoriteGist: Gist) = favoritesRepository.insertFavoriteGist(favoriteGist)
}
