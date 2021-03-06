package com.dloprodu.marvelheroes.di.components

import com.dloprodu.marvelheroes.di.modules.ApplicationModule
import com.dloprodu.marvelheroes.di.modules.DataModule
import com.dloprodu.marvelheroes.di.modules.NetModule
import com.dloprodu.marvelheroes.presentation.heroedetail.MarvelHeroeDetailActivity
import com.dloprodu.marvelheroes.presentation.heroeslist.HeroesListActivity
import com.dloprodu.marvelheroes.util.mvvm.ViewModelModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ApplicationModule::class,
    NetModule::class,
    DataModule::class,
    ViewModelModule::class
])
interface ApplicationComponent {

    fun inject(userListActivity: HeroesListActivity)

    fun inject(detailActivity: MarvelHeroeDetailActivity)
}