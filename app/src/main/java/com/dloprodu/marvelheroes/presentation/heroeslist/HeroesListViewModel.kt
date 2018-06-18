package com.dloprodu.marvelheroes.presentation.heroeslist

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.dloprodu.marvelheroes.domain.model.MarvelHeroEntity
import com.dloprodu.marvelheroes.domain.usecase.GetMarvelHeroesList
import com.dloprodu.marvelheroes.util.mvvm.mvvm.BaseViewModel
import javax.inject.Inject

class HeroesListViewModel @Inject constructor(
        private val getMarvelHeroesList: GetMarvelHeroesList
    ): BaseViewModel() {

    val userListState: MutableLiveData<List<MarvelHeroEntity>> = MutableLiveData()
    val isLoadingState: MutableLiveData<Boolean> = MutableLiveData()

    fun loadHeroesList() {
        getMarvelHeroesList.execute(
            { heroes ->
                userListState.value = heroes
            }, {
                Log.d("HeroesListViewModel", it.toString())
            }, {
                isLoadingState.postValue(true)
            }, {
                isLoadingState.postValue(false)
                // settingsManager.firstLoad = false
            }
        )
    }
}