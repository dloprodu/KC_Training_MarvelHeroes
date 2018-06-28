package com.dloprodu.marvelheroes.data.repository

import com.dloprodu.marvelheroes.data.repository.datasource.LocalMarvelHeroesDataSource
import com.dloprodu.marvelheroes.data.repository.datasource.RemoteMarvelHeroesDataSource
import com.dloprodu.marvelheroes.domain.model.MarvelHeroEntity
import io.reactivex.Observable

class MarvelHeroesRepositoryImpl(private val remoteMarvelHeroesDataSource: RemoteMarvelHeroesDataSource,
                                 private val localMarvelHeroesDataSource: LocalMarvelHeroesDataSource)
    : MarvelHeroesRepository {

    override fun getMarvelHeroesListFromApi(): Observable<List<MarvelHeroEntity>> =
        remoteMarvelHeroesDataSource
                .getMarvelHeroesList()


    override fun getMarvelHeroesListFromDb(): Observable<List<MarvelHeroEntity>> =
            localMarvelHeroesDataSource
                    .getMarvelHeroesList()

}