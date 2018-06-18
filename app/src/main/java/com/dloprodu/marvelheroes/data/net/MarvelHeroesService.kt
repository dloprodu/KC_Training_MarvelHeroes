package com.dloprodu.marvelheroes.data.net

import com.dloprodu.marvelheroes.data.model.MarvelHeroesResponse
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by dloprodu on 17/03/2018.
 */
interface MarvelHeroesService {

    @GET(".")
    fun getMarvelHeroesList(): Observable<MarvelHeroesResponse>

}