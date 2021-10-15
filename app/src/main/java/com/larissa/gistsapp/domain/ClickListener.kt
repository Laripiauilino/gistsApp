package com.larissa.gistsapp.domain

import com.larissa.gistsapp.data.model.Gist


interface ClickListener {
    fun onFavoriteClickListener(gist: Gist, isChecked: Boolean, position: Int)
}
