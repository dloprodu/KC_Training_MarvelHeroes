package com.dloprodu.marvelheroes.presentation.heroedetail

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.dloprodu.marvelheroes.domain.model.FavoriteHeroEntity
import com.dloprodu.marvelheroes.domain.usecase.GetFavoriteHeroesList
import com.dloprodu.marvelheroes.util.mvvm.mvvm.BaseViewModel
import javax.inject.Inject


class MarvelHeroeDetailViewModel @Inject constructor(
        private val getAllFavorites: GetFavoriteHeroesList
): BaseViewModel() {

    val favoriteListState: MutableLiveData<List<FavoriteHeroEntity>> = MutableLiveData()
    val isLoadingState: MutableLiveData<Boolean> = MutableLiveData()

    fun loadFavorites() {
        getAllFavorites.execute(
        { heroes ->
            favoriteListState.value = heroes
        }, {
            Log.d("FavoriteListViewModel", it.toString())
        }, {
            isLoadingState.postValue(true)
        }, {
            isLoadingState.postValue(false)
            // settingsManager.firstLoad = false
        })
    }

    fun markHeroAsFavorite(name: String) {
        val favorite = FavoriteHeroEntity(0, name)
        this.getAllFavorites.markAsFavorite(favorite)
        favoriteListState.value = listOf(favorite)
    }

    fun unmarkHeroAsFavorite(name: String) {
        this.getAllFavorites.unMarkAsFavorite(name)
        favoriteListState.value = listOf()
    }
}