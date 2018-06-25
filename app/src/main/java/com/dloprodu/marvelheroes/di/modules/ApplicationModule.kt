package com.dloprodu.marvelheroes.di.modules

import android.app.Application
import android.content.Context
import com.dloprodu.marvelheroes.presentation.MainApp
import com.dloprodu.marvelheroes.util.Navigator
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by dloprodu on 16/03/2018.
 */
@Module
class ApplicationModule(private val application: MainApp) {

    @Provides
    @Singleton
    fun provideApp(): Application = application

    @Provides
    @Singleton
    fun provideContext(): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideNavigator(): Navigator = Navigator()

}