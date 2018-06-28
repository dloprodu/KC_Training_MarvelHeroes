package com.dloprodu.marvelheroes.data.model.mapper

import com.dloprodu.marvelheroes.data.model.MarvelHero
import com.dloprodu.marvelheroes.domain.model.MarvelHeroEntity

class MarvelHeroMapper : Mapper<MarvelHero, MarvelHeroEntity> {

    override fun transform(input: MarvelHero): MarvelHeroEntity =
            MarvelHeroEntity(
                    0,
                    input.name,
                    input.photoUrl,
                    input.realName,
                    input.height,
                    input.power,
                    input.abilities,
                    input.groups
            )

    override fun transformList(inputList: List<MarvelHero>): List<MarvelHeroEntity> =
            inputList.map { transform(it) }

}