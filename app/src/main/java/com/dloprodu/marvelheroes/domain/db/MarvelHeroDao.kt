package com.dloprodu.marvelheroes.domain.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.dloprodu.marvelheroes.domain.model.MarvelHeroEntity
import io.reactivex.Maybe

@Dao
abstract class MarvelHeroDao {
    @Query("SELECT * FROM heroes")
    abstract fun getAllHeroes(): Maybe<List<MarvelHeroEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertAll(heroes: List<MarvelHeroEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(hero: MarvelHeroEntity)
}