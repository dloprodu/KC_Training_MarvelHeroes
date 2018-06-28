package com.dloprodu.marvelheroes.domain.db

import android.arch.persistence.room.*
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

    @Query("DELETE FROM heroes")
    abstract fun deleteAllHeroes()

    @Transaction
    open fun removeAndInsertHeroes(heroes: List<MarvelHeroEntity>) {
        deleteAllHeroes()
        insertAll(heroes)
    }
}