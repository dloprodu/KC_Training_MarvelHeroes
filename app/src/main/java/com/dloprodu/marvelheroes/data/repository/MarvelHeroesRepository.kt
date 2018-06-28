package com.dloprodu.marvelheroes.data.repository

import com.dloprodu.marvelheroes.domain.model.MarvelHeroEntity
import io.reactivex.Observable

interface MarvelHeroesRepository {

    fun getMarvelHeroesListFromApi(): Observable<List<MarvelHeroEntity>>

    fun getMarvelHeroesListFromDb(): Observable<List<MarvelHeroEntity>>
}