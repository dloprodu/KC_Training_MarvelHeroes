package com.dloprodu.marvelheroes.domain.usecase

import com.dloprodu.marvelheroes.data.repository.MarvelHeroesRepositoryImpl
import com.dloprodu.marvelheroes.domain.model.MarvelHeroEntity
import io.reactivex.Observable
import javax.inject.Inject

class MarkMarvelHeroAsFavorite @Inject constructor(val marvelHeroesRepositoryImpl: MarvelHeroesRepositoryImpl)
    : UseCase<List<MarvelHeroEntity>>() {

    override fun buildCase(): Observable<List<MarvelHeroEntity>> =
            marvelHeroesRepositoryImpl.getMarvelHeroesList()
}