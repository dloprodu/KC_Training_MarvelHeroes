package com.dloprodu.marvelheroes.util.mvvm

import android.app.Activity
import android.content.Intent
import android.support.v4.app.ActivityOptionsCompat
import android.support.v4.view.ViewCompat
import android.view.View
import com.dloprodu.marvelheroes.domain.model.MarvelHeroEntity
import com.dloprodu.marvelheroes.presentation.heroedetail.MarvelHeroeDetailActivity

/**
 * Created by dloprodu on 17/03/2018.
 */
class Navigator {

    fun goToHeroDetail(activity: Activity, hero: MarvelHeroEntity, image: View) {
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity, image,
                ViewCompat.getTransitionName(image))
        val intent = Intent(activity, MarvelHeroeDetailActivity::class.java).apply {
            putExtra(MarvelHeroeDetailActivity.PARAM_HEROE, hero)
        }

        activity.startActivity(intent, options.toBundle())
    }

}