package com.dloprodu.marvelheroes.domain.db

import android.arch.persistence.room.*
import com.dloprodu.marvelheroes.domain.model.FavoriteHeroEntity
import io.reactivex.Maybe

@Dao
abstract class FavoriteHeroDao {

    @Query("SELECT * FROM favorites")
    abstract fun getAllFavorites(): Maybe<List<FavoriteHeroEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(favorite: FavoriteHeroEntity)

    @Query("DELETE FROM favorites WHERE name = :name")
    abstract fun delete(name: String)
}