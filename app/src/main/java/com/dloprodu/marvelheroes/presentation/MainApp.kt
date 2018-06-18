package com.dloprodu.marvelheroes.presentation

import android.app.Application
import com.dloprodu.marvelheroes.di.components.ApplicationComponent
import com.dloprodu.marvelheroes.di.components.DaggerApplicationComponent
import com.dloprodu.marvelheroes.di.modules.ApplicationModule

/**
 * Created by dloprodu on 16/03/2018.
 */
class MainApp : Application() {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
    }

}