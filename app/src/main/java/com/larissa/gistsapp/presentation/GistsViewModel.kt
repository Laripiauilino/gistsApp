package com.larissa.gistsapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.larissa.gistsapp.data.model.Gist
import com.larissa.gistsapp.domain.FetchAllGistsUseCase
import com.larissa.gistsapp.domain.DeleteFavoriteUseCase
import com.larissa.gistsapp.domain.InsertFavoriteUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class GistsViewModel : ViewModel(){

    private val _allGistsLiveData = MutableLiveData<List<Gist>>()
    val allGistsLiveData: LiveData<List<Gist>> = _allGistsLiveData

    private val fetchAllGistsUseCase = FetchAllGistsUseCase()
    private val deleteFavoriteUseCase = DeleteFavoriteUseCase()
    private val insertFavoriteUseCase = InsertFavoriteUseCase()

    private val compositeDisposable = CompositeDisposable()

    fun getAllGists() {
        compositeDisposable.add(fetchAllGistsUseCase.execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                _allGistsLiveData.value = it
            })
    }

    fun insertFavorite(favoriteGist: Gist){
        compositeDisposable.add(insertFavoriteUseCase.execute(favoriteGist)
            .subscribeOn(Schedulers.io())
            .subscribe()
        )
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




