package com.dloprodu.marvelheroes.presenter

import com.dloprodu.marvelheroes.domain.usecase.GetMarvelHeroesList
import com.dloprodu.marvelheroes.presentation.heroeslist.HeroesListContract
import com.dloprodu.marvelheroes.presentation.heroeslist.HeroesListPresenter
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Test

/**
 * Created by dloprodu on 17/03/2018.
 */
class HeroesListPresenterTest {

    val view: HeroesListContract.View = mock()
    val usecase: GetMarvelHeroesList = mock()

    lateinit var presenter: HeroesListPresenter

    @Before
    fun setUp() {
        presenter = HeroesListPresenter(view, usecase)
    }

    @Test
    fun `test presenter initialization`() {
        presenter.loadMarvelHeroes()

        verify(view).showLoading(true)
        verify(usecase).execute(any(), any())
    }

}