package com.dloprodu.marvelheroes.data.repository

import com.dloprodu.marvelheroes.data.repository.datasource.LocalMarvelHeroesDataSource
import com.dloprodu.marvelheroes.data.repository.datasource.RemoteMarvelHeroesDataSource
import com.dloprodu.marvelheroes.domain.model.FavoriteHeroEntity
import com.dloprodu.marvelheroes.domain.model.MarvelHeroEntity
import io.reactivex.Observable

class MarvelHeroesRepositoryImpl(private val remoteMarvelHeroesDataSource: RemoteMarvelHeroesDataSource,
                                 private val localMarvelHeroesDataSource: LocalMarvelHeroesDataSource)
    : MarvelHeroesRepository {

    override fun getMarvelHeroesList(): Observable<List<MarvelHeroEntity>> =
            getMarvelHeroesListFromDb().concatWith(getMarvelHeroesListFromApi())

    override fun getMarvelHeroesListFromApi(): Observable<List<MarvelHeroEntity>> =
        remoteMarvelHeroesDataSource
                .getMarvelHeroesList()
                .doOnNext { localMarvelHeroesDataSource.saveHeroes(it) }


    override fun getMarvelHeroesListFromDb(): Observable<List<MarvelHeroEntity>> =
            localMarvelHeroesDataSource
                    .getMarvelHeroesList()

    override fun getFavorite(name: String): Observable<List<FavoriteHeroEntity>> {
        return localMarvelHeroesDataSource.getFavorite(name)
    }

    override fun markMarvelHeroAsFavorite(favorite: FavoriteHeroEntity) {
        localMarvelHeroesDataSource.saveFavorite(favorite)
    }

    override fun unmarkMarvelHeroAsFavorite(name: String) {
        localMarvelHeroesDataSource.deleteFavorite(name)
    }

}