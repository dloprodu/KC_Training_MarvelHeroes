package com.dloprodu.marvelheroes.presentation.heroedetail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.app.AppCompatDelegate
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.dloprodu.marvelheroes.R
import com.dloprodu.marvelheroes.domain.model.FavoriteHeroEntity
import com.dloprodu.marvelheroes.domain.model.MarvelHeroEntity
import com.dloprodu.marvelheroes.presentation.MainApp
import kotlinx.android.synthetic.main.activity_hero_detail.*
import javax.inject.Inject

/**
 * Created by dloprodu on 18/03/2018.
 */
class MarvelHeroeDetailActivity : AppCompatActivity() {

    companion object {
        const val PARAM_HEROE = "heroe"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var heroDetailViewModel: MarvelHeroeDetailViewModel

    var hero: MarvelHeroEntity? = null
    var favorite: FavoriteHeroEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        inject()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_detail)
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeButtonEnabled(true)
        }
        supportPostponeEnterTransition() // Wait for image load and then draw the animation

        loadHeroEntity()
        setUpViewModel()
        setUpUI()
    }

    fun inject() {
        (application as MainApp).component.inject(this)
    }

    fun setUpViewModel() {
        heroDetailViewModel = ViewModelProviders.of(this, viewModelFactory).get(MarvelHeroeDetailViewModel::class.java)
        bindEvents()
        heroDetailViewModel.loadFavorites()
    }

    fun setUpUI() {
        buttonFavorite.setOnClickListener {
            hero?.let {
                if (this.favorite == null) {
                    this.heroDetailViewModel.markHeroAsFavorite(it.name);
                } else {
                    this.heroDetailViewModel.unmarkHeroAsFavorite(it.name)
                }
            }
        }
    }

    private fun loadHeroEntity() {
        hero = intent?.extras?.getParcelable(PARAM_HEROE)
        hero?.let { fillHeroData(it) }
    }

    private fun bindEvents() {
        heroDetailViewModel.favoriteListState.observe(this, Observer { favoriteList ->
            hero?.let {
                val hero = it
                favoriteList?.let {
                    this.favorite = it.find { f -> f.name == hero.name }

                    setUpFavorite()
                }
            }
        })
    }

    private fun fillHeroData(hero: MarvelHeroEntity) {
        Glide.with(this)
                .load(hero.photoUrl)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                        supportStartPostponedEnterTransition()
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        supportStartPostponedEnterTransition()
                        return false
                    }
                })
                .into(heroDetailImage)

        heroDetailName.text = hero.name
        heroDetailRealName.text = hero.realName
        heroDetailHeight.text = hero.height
        heroDetailPower.text = hero.power
        heroDetailAbilities.text = hero.abilities
    }

    private fun setUpFavorite() {
        this.buttonFavorite.setBackgroundColor( if (this.favorite != null)
            { ContextCompat.getColor(this, R.color.favorite) }
            else { ContextCompat.getColor(this, R.color.button_material_light) } )
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when(item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}