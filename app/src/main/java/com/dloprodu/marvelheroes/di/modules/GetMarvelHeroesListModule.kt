package com.dloprodu.marvelheroes.di.modules

import com.dloprodu.marvelheroes.data.repository.MarvelHeroesRepositoryImpl
import com.dloprodu.marvelheroes.di.scopes.PerActivity
import com.dloprodu.marvelheroes.domain.usecase.GetMarvelHeroesList
import com.dloprodu.marvelheroes.presentation.heroeslist.HeroesListActivity
import com.dloprodu.marvelheroes.presentation.heroeslist.HeroesListContract
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by dloprodu on 17/03/2018.
 */
@Module
class GetMarvelHeroesListModule(private val view: HeroesListActivity) {

    @Provides
    @PerActivity
    fun provideView(): HeroesListContract.View = view

    @Provides
    @PerActivity
    fun provideGetListHeroesUseCase(marvelHeroesRepositoryImpl: MarvelHeroesRepositoryImpl): GetMarvelHeroesList =
            GetMarvelHeroesList(marvelHeroesRepositoryImpl)

}