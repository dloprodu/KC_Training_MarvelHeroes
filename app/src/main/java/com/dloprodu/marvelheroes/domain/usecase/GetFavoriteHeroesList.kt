package com.dloprodu.marvelheroes.domain.usecase

import com.dloprodu.marvelheroes.data.repository.MarvelHeroesRepositoryImpl
import com.dloprodu.marvelheroes.domain.model.FavoriteHeroEntity
import io.reactivex.Observable
import javax.inject.Inject

class GetFavoriteHeroesList @Inject constructor(val marvelHeroesRepositoryImpl: MarvelHeroesRepositoryImpl)
    : UseCase<List<FavoriteHeroEntity>>() {

    override fun buildCase(): Observable<List<FavoriteHeroEntity>> =
            marvelHeroesRepositoryImpl.getAllFavorites()

    fun markAsFavorite(favorite: FavoriteHeroEntity) {
        marvelHeroesRepositoryImpl.markMarvelHeroAsFavorite(favorite)
    }

    fun unMarkAsFavorite(name: String) {
        marvelHeroesRepositoryImpl.unmarkMarvelHeroAsFavorite(name)
    }
}