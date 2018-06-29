package com.dloprodu.marvelheroes.presentation.heroedetail

import com.dloprodu.marvelheroes.domain.usecase.MarkMarvelHeroAsFavorite
import com.dloprodu.marvelheroes.domain.usecase.UnmarkMarvelHeroAsFavorite
import com.dloprodu.marvelheroes.util.mvvm.mvvm.BaseViewModel
import javax.inject.Inject


class MarvelHeroeDetailViewModel @Inject constructor(
        private val markAsFavorite: MarkMarvelHeroAsFavorite,
        private val unmarkAsFavorite: UnmarkMarvelHeroAsFavorite
): BaseViewModel() {
    fun markHeroAsFavorite() {
       markAsFavorite.execute({}, {}, {}, {})
    }

    fun unmarkHeroAsFavorite() {
        unmarkAsFavorite.execute({}, {}, {}, {})
    }
}