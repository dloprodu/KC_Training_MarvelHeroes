package com.dloprodu.marvelheroes.di.components

import com.dloprodu.marvelheroes.di.modules.GetMarvelHeroesListModule
import com.dloprodu.marvelheroes.di.scopes.PerActivity
import com.dloprodu.marvelheroes.presentation.heroeslist.HeroesListActivity
import dagger.Component

/**
 * Created by dloprodu on 17/03/2018.
 */
@PerActivity
@Component(modules = [GetMarvelHeroesListModule::class], dependencies = [ApplicationComponent::class])
interface GetMarvelHeroesListComponent {

    fun inject(marvelListActivity: HeroesListActivity)

}