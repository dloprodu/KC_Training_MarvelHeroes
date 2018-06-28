package com.dloprodu.marvelheroes.data.repository.datasource

import com.dloprodu.marvelheroes.domain.model.MarvelHeroEntity
import io.reactivex.Observable

/**
 * Created by dloprodu on 17/03/2018.
 */
interface MarvelHeroesDataSource {

    fun getMarvelHeroesList(): Observable<List<MarvelHeroEntity>>

}