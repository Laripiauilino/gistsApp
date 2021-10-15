package com.larissa.gistsapp.data.db.service

import androidx.room.*
import com.larissa.gistsapp.data.model.Gist
import io.reactivex.Completable
import io.reactivex.Observable


@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite(favorite: Gist) : Completable

    @Delete
    fun deleteFavorite(favorite: Gist) : Completable

    @Query("SELECT * FROM favoritesTable")
    fun getFavorites() : Observable<List<Gist>>
}