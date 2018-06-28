package com.dloprodu.marvelheroes.domain.model

import android.annotation.SuppressLint
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "heroes")
@SuppressLint("ParcelCreator")
@Parcelize
data class MarvelHeroEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val name: String,
        val photoUrl: String,
        val realName: String,
        val height: String,
        val power: String,
        val abilities: String,
        val groups: String
) : Parcelable {

      //fun getGroups(): Array<String> =
      //          this.groups.replace("\\s".toRegex(), "").split(",").toTypedArray()
}