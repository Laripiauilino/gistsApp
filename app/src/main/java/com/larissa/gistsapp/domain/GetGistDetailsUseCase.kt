package com.larissa.gistsapp.domain

import com.larissa.gistsapp.data.repository.GistsRepository
import com.larissa.gistsapp.data.repository.GistsRepositoryImp

class GetGistDetailsUseCase (
    private val gistsRepository: GistsRepository = GistsRepositoryImp()
) {
    fun execute() = gistsRepository.getGistUserDetails()
}