package com.dloprodu.marvelheroes.domain.model

import android.annotation.SuppressLint
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "favorites")
@SuppressLint("ParcelCreator")
@Parcelize
data class FavoriteHeroEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val name: String
) : Parcelable