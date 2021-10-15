package com.larissa.gistsapp.data.repository
import android.content.Context
import com.larissa.gistsapp.data.db.base.DatabaseBuilder
import com.larissa.gistsapp.data.db.base.FavoriteDatabase
import com.larissa.gistsapp.data.model.Gist
import io.reactivex.Completable
import io.reactivex.Observable

class FavoriteRepository {

    fun insertFavoriteGist(favoriteGist: Gist) : Completable  {
        return DatabaseBuilder.getFavoriteDatabase().favoriteDao().insertFavorite(favoriteGist)
    }

    fun deleteFavoriteGist(favoriteGist: Gist) : Completable {
        return DatabaseBuilder.getFavoriteDatabase().favoriteDao().deleteFavorite(favoriteGist)
    }

    fun fetchFavoriteGists(): Observable<List<Gist>> =
         DatabaseBuilder.getFavoriteDatabase().favoriteDao().getFavorites()

}

//class FavoriteRepository {
//
//    private var db: FavoriteDatabase? = null
//
//    fun insertFavoriteGist(context: Context, favoriteGist: Gist) {
//        db = DatabaseBuilder.getFavoriteDatabase(context)
//        db?.favoriteDao()?.insertFavorite(favoriteGist)
//    }
//
//    fun deleteFavoriteGist(context: Context , favoriteGist: Gist) {
//        db = DatabaseBuilder.getFavoriteDatabase(context)
//        db?.favoriteDao()?.deleteFavorite(favoriteGist)
//    }
//
//    fun fetchFavoriteGists(context: Context): Observable<List<Gist>>? {
//        var favoritesList: Observable<List<Gist>>?
//        db = DatabaseBuilder.getFavoriteDatabase(context)
//        val favoriteDao = db?.favoriteDao()
//        favoritesList = favoriteDao?.getFavorites()
//
//        return favoritesList
//
//    }
//}