package com.dloprodu.marvelheroes.data.model.mapper

import com.dloprodu.marvelheroes.data.model.MarvelHero
import com.dloprodu.marvelheroes.domain.model.MarvelHeroEntity

/**
 * Created by dloprodu on 17/03/2018.
 */
class MarvelHeroMapper : Mapper<MarvelHero, MarvelHeroEntity> {

    override fun transform(input: MarvelHero): MarvelHeroEntity =
            MarvelHeroEntity(
                    0,
                    false,
                    input.name,
                    input.photoUrl,
                    input.realName,
                    input.height,
                    input.power,
                    input.abilities,
                    input.groups)

    override fun transformList(inputList: List<MarvelHero>): List<MarvelHeroEntity> =
            inputList.map { transform(it) }

}