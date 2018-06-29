package com.dloprodu.marvelheroes.data.repository.datasource

import com.dloprodu.marvelheroes.data.model.mapper.MarvelHeroMapper
import com.dloprodu.marvelheroes.data.net.MarvelHeroesService
import com.dloprodu.marvelheroes.domain.model.MarvelHeroEntity
import io.reactivex.Observable

/**
 * Created by dloprodu on 17/03/2018.
 */
class RemoteMarvelHeroesDataSource(
        private val marvelHeroesService: MarvelHeroesService,
        private val marvelHeroesMapper: MarvelHeroMapper):
        MarvelHeroesDataSource {

    override fun getMarvelHeroesList(): Observable<List<MarvelHeroEntity>> =
            marvelHeroesService
                    .getMarvelHeroesList()
                    .map { marvelHeroesMapper.transformList(it.superheroes) }

}