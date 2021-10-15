package com.larissa.gistsapp.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "favoritesTable")
class Gist(
    @PrimaryKey(autoGenerate = true)
    val ownerId: Int = 0,
    val ownerLogin: String? = null,
    val ownerPicture: String? = null,
    val fileType: String? = null,
    var isFavorite: Boolean = false)