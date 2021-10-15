package com.larissa.gistsapp.domain

import com.larissa.gistsapp.data.repository.GistsRepository
import com.larissa.gistsapp.data.repository.GistsRepositoryImp


class FetchAllGistsUseCase (
    private val gistsRepository: GistsRepository = GistsRepositoryImp()
) {
    fun execute() = gistsRepository.getAllGists()
}