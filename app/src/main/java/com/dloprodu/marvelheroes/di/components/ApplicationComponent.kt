package com.dloprodu.marvelheroes.di.components

import android.content.Context
import com.dloprodu.marvelheroes.data.net.MarvelHeroesService
import com.dloprodu.marvelheroes.data.repository.MarvelHeroesRepositoryImpl
import com.dloprodu.marvelheroes.di.modules.ApplicationModule
import com.dloprodu.marvelheroes.di.modules.DataModule
import com.dloprodu.marvelheroes.di.modules.NetModule
import com.dloprodu.marvelheroes.util.mvvm.Navigator
import dagger.Component
import javax.inject.Singleton

/**
 * Created by dloprodu on 16/03/2018.
 */
@Singleton
@Component(modules = [ApplicationModule::class, NetModule::class, DataModule::class])
interface ApplicationComponent {

    fun getContext(): Context
    fun getRepository(): MarvelHeroesRepositoryImpl
    fun getHeroService(): MarvelHeroesService
    fun getNavigator(): Navigator

}