package com.dloprodu.marvelheroes.presentation.heroeslist

import com.dloprodu.marvelheroes.domain.usecase.GetMarvelHeroesList
import javax.inject.Inject

/**
 * Created by dloprodu on 17/03/2018.
 */
class HeroesListPresenter @Inject constructor(private val view: HeroesListContract.View,
                                              private val getMarvelHeroesList: GetMarvelHeroesList)
    : HeroesListContract.Presenter {

    override fun resume() {

    }

    override fun pause() {

    }

    override fun destroy() {
        getMarvelHeroesList.dispose()
    }

    override fun loadMarvelHeroes() {

        getMarvelHeroesList.execute({ heroes ->
            view.showHeroesList(heroes)
        }, {
            view.showError(it.toString())
        }, {
            view.showLoading(true)
        },{
            view.showLoading(false)
        })
    }

}