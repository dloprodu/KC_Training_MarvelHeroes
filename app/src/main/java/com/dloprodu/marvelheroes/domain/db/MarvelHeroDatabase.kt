package com.dloprodu.marvelheroes.domain.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.dloprodu.marvelheroes.domain.model.MarvelHeroEntity

@Database(entities = [MarvelHeroEntity::class], version = 1)
abstract class MarvelHeroDatabase : RoomDatabase()  {

    abstract fun getUserDao(): MarvelHeroDao
}
