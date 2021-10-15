package com.larissa.gistsapp.data.api.response

data class GistsResponse(
    val owner: OwnerResponse,
    val files: Map<String,FilesResponse>,
    val isFavorite: Boolean = false
)






