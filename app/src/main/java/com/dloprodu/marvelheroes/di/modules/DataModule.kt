package com.dloprodu.marvelheroes.di.modules

import android.arch.persistence.room.Room
import android.content.Context
import com.dloprodu.marvelheroes.data.model.mapper.MarvelHeroMapper
import com.dloprodu.marvelheroes.data.net.MarvelHeroesService
import com.dloprodu.marvelheroes.data.repository.MarvelHeroesRepositoryImpl
import com.dloprodu.marvelheroes.data.repository.datasource.LocalMarvelHeroesDataSource
import com.dloprodu.marvelheroes.data.repository.datasource.RemoteMarvelHeroesDataSource
import com.dloprodu.marvelheroes.domain.db.MarvelHeroDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun provideMarvelHeroMapper(): MarvelHeroMapper = MarvelHeroMapper()

    @Singleton
    @Provides
    fun provideDatabase(context: Context): MarvelHeroDatabase =
            Room.databaseBuilder(context, MarvelHeroDatabase::class.java, "hero.db")
                    .fallbackToDestructiveMigration()
                    .build()

    @Provides
    @Singleton
    fun provideRemoteMarvelHeroesDataSoruce(
            marvelHeroesService: MarvelHeroesService,
            marvelHeroMapper: MarvelHeroMapper)
            : RemoteMarvelHeroesDataSource =
            RemoteMarvelHeroesDataSource(marvelHeroesService, marvelHeroMapper)

    @Provides
    @Singleton
    fun provideLocalMarvelHeroesDataSoruce(
            database: MarvelHeroDatabase)
            : LocalMarvelHeroesDataSource =
            LocalMarvelHeroesDataSource(database)

    @Provides
    @Singleton
    fun provideMarvelHeroesRepository(
            remoteMarvelHeroesDataSource: RemoteMarvelHeroesDataSource,
            localMarvelHeroesDataSource: LocalMarvelHeroesDataSource): MarvelHeroesRepositoryImpl =
            MarvelHeroesRepositoryImpl(remoteMarvelHeroesDataSource, localMarvelHeroesDataSource)

}