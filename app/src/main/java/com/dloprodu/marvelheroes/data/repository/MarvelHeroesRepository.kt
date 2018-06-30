package com.dloprodu.marvelheroes.data.repository

import com.dloprodu.marvelheroes.domain.model.FavoriteHeroEntity
import com.dloprodu.marvelheroes.domain.model.MarvelHeroEntity
import io.reactivex.Observable

interface MarvelHeroesRepository {

    fun getMarvelHeroesList(): Observable<List<MarvelHeroEntity>>

    fun getMarvelHeroesListFromApi(): Observable<List<MarvelHeroEntity>>

    fun getMarvelHeroesListFromDb(): Observable<List<MarvelHeroEntity>>

    fun getAllFavorites(): Observable<List<FavoriteHeroEntity>>

    fun markMarvelHeroAsFavorite(favorite: FavoriteHeroEntity)

    fun unmarkMarvelHeroAsFavorite(name: String)
}