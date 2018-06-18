package com.dloprodu.marvelheroes.data.repository.datasource

import com.dloprodu.marvelheroes.data.model.MarvelHero
import com.dloprodu.marvelheroes.data.net.MarvelHeroesService
import io.reactivex.Observable

/**
 * Created by dloprodu on 17/03/2018.
 */
class RemoteMarvelHeroesDataSource(private val marvelHeroesService: MarvelHeroesService):
        MarvelHeroesDataSource {

    override fun getMarvelHeroesList(): Observable<List<MarvelHero>> =
            marvelHeroesService.getMarvelHeroesList().map { it.superheroes }

}