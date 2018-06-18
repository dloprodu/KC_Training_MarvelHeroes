package com.dloprodu.marvelheroes.di.modules

import com.dloprodu.marvelheroes.data.model.mapper.MarvelHeroMapper
import com.dloprodu.marvelheroes.data.net.MarvelHeroesService
import com.dloprodu.marvelheroes.data.repository.MarvelHeroesRepositoryImpl
import com.dloprodu.marvelheroes.data.repository.datasource.RemoteMarvelHeroesDataSource
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by dloprodu on 17/03/2018.
 */
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideMarvelHeroMapper(): MarvelHeroMapper = MarvelHeroMapper()

    @Provides
    @Singleton
    fun provideRemoteMarvelHeroesDataSoruce(marvelHeroesService: MarvelHeroesService)
            : RemoteMarvelHeroesDataSource =
            RemoteMarvelHeroesDataSource(marvelHeroesService)

    @Provides
    @Singleton
    fun provideMarvelHeroesRepository(
            marvelRemoteMarvelHeroesDataSource: RemoteMarvelHeroesDataSource,
            marvelHeroMapper: MarvelHeroMapper): MarvelHeroesRepositoryImpl =
            MarvelHeroesRepositoryImpl(marvelRemoteMarvelHeroesDataSource, marvelHeroMapper)

}