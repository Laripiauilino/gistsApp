package com.larissa.gistsapp.presentation

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.larissa.gistsapp.data.model.Gist
import com.larissa.gistsapp.domain.FetchAllGistsUseCase
import com.larissa.gistsapp.domain.DeleteFavoriteUseCase
import com.larissa.gistsapp.domain.GetFavoritesUseCase
import com.larissa.gistsapp.domain.InsertFavoriteUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers


class FavoriteGistsViewModel : ViewModel(){

    private val _favoritesLiveData = MutableLiveData<List<Gist>>()
    val favoritesLiveData: MutableLiveData<List<Gist>> = _favoritesLiveData

    private val getFavoritesUseCase = GetFavoritesUseCase()
    private val deleteFavoriteUseCase = DeleteFavoriteUseCase()

    private val compositeDisposable = CompositeDisposable()

    fun getFavoriteGists(){
        compositeDisposable.add(getFavoritesUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                    _favoritesLiveData.value = it
                })
    }

    fun deleteFavorite(favoriteGist: Gist){
        compositeDisposable.add(deleteFavoriteUseCase.execute(favoriteGist)
            .subscribeOn(Schedulers.io())
            .subscribe()
        )
    }

    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}




