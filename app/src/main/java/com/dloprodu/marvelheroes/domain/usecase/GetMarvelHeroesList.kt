package com.dloprodu.marvelheroes.domain.usecase

import com.dloprodu.marvelheroes.data.repository.MarvelHeroesRepositoryImpl
import com.dloprodu.marvelheroes.domain.model.MarvelHeroEntity
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by dloprodu on 17/03/2018.
 */
class GetMarvelHeroesList @Inject constructor(val marvelHeroesRepositoryImpl: MarvelHeroesRepositoryImpl)
    : UseCase<List<MarvelHeroEntity>>() {

    override fun buildCase(): Observable<List<MarvelHeroEntity>> =
            marvelHeroesRepositoryImpl.getMarvelHeroesList()

}