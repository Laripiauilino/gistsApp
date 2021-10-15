package com.larissa.gistsapp.data.repository

import com.larissa.gistsapp.data.api.base.Network
import com.larissa.gistsapp.data.api.service.GistsService
import com.larissa.gistsapp.data.mapper.GistsMapper
import com.larissa.gistsapp.data.model.Gist
import com.larissa.gistsapp.data.model.GistDetails
import io.reactivex.Observable

class GistsRepositoryImp : GistsRepository {
    private val gistMapper = GistsMapper()
    private val gistsService: GistsService = Network.getService()

    override fun getAllGists(): Observable<List<Gist>>  =
        gistsService.getAllGists().map(gistMapper::mapFromResponseToGist)

    override fun getGistUserDetails(): Observable<GistDetails> =
        gistsService.getGistUserDetails().map(gistMapper::mapFromResponseToGistDetails)
}



