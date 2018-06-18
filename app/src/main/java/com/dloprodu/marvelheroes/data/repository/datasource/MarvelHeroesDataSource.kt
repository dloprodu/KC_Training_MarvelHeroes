package com.dloprodu.marvelheroes.data.repository.datasource

import com.dloprodu.marvelheroes.data.model.MarvelHero
import io.reactivex.Observable

/**
 * Created by dloprodu on 17/03/2018.
 */
interface MarvelHeroesDataSource {

    fun getMarvelHeroesList(): Observable<List<MarvelHero>>

}