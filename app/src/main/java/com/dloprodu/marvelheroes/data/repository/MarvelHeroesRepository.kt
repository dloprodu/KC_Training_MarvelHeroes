package com.dloprodu.marvelheroes.data.repository

import com.dloprodu.marvelheroes.domain.model.MarvelHeroEntity
import io.reactivex.Observable

/**
 * Created by dloprodu on 17/03/2018.
 */
interface MarvelHeroesRepository {

    fun getMarvelHeroesList(): Observable<List<MarvelHeroEntity>>

}