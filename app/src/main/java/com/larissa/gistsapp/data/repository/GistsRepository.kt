package com.larissa.gistsapp.data.repository


import com.larissa.gistsapp.data.model.Gist
import com.larissa.gistsapp.data.model.GistDetails
import io.reactivex.Observable

interface GistsRepository {

     fun getAllGists(): Observable<List<Gist>>

     fun getGistUserDetails(): Observable<GistDetails>
}