package com.dloprodu.marvelheroes.data.repository.datasource

import com.dloprodu.marvelheroes.domain.db.MarvelHeroDatabase
import com.dloprodu.marvelheroes.domain.model.MarvelHeroEntity
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers


class LocalMarvelHeroesDataSource(private val heroDatabase: MarvelHeroDatabase):
        MarvelHeroesDataSource {

    override fun getMarvelHeroesList(): Observable<List<MarvelHeroEntity>> =
            heroDatabase
                    .getHeroDao()
                    .getAllHeroes()
                    .toObservable()

    fun saveUsers(heroes: List<MarvelHeroEntity>) {
        Observable.fromCallable {
            heroDatabase.getHeroDao().removeAndInsertHeroes(heroes)
        }
                .subscribeOn(Schedulers.io())
                .subscribe()
    }
}