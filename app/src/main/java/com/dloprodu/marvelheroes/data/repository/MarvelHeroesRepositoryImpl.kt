package com.dloprodu.marvelheroes.data.repository

import com.dloprodu.marvelheroes.data.model.mapper.MarvelHeroMapper
import com.dloprodu.marvelheroes.data.repository.datasource.FakeMarvelHeroesDataSource
import com.dloprodu.marvelheroes.data.repository.datasource.RemoteMarvelHeroesDataSource
import com.dloprodu.marvelheroes.domain.model.MarvelHeroEntity
import io.reactivex.Observable

/**
 * Created by dloprodu on 17/03/2018.
 */
class MarvelHeroesRepositoryImpl(private val remoteMarvelHeroesDataSource: RemoteMarvelHeroesDataSource,
                                 private val marvelHeroesMapper: MarvelHeroMapper)
    : MarvelHeroesRepository {

    override fun getMarvelHeroesList(): Observable<List<MarvelHeroEntity>> =
        remoteMarvelHeroesDataSource
                .getMarvelHeroesList()
                .map { marvelHeroesMapper.transformList(it) }

}