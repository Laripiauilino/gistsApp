package com.larissa.gistsapp.data.api.service

import com.larissa.gistsapp.data.api.response.GistDetailsResponse
import com.larissa.gistsapp.data.api.response.GistsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface GistsService {

    @GET("gists/public")
    fun getAllGists(): Observable<List<GistsResponse>>

    @GET("users/{username}/gists")
    fun getGistUserDetails(): Observable<GistDetailsResponse>
}