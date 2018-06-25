package com.dloprodu.marvelheroes.domain.model

import android.annotation.SuppressLint
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by dloprodu on 17/03/2018.
 */
@Entity(tableName = "heroes")
@SuppressLint("ParcelCreator")
@Parcelize
data class MarvelHeroEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Long,
        val favorite: Boolean = false,
        val name: String,
        val photoUrl: String,
        val realName: String,
        val height: String,
        val power: String,
        val abilities: String,
        val groups: String
) : Parcelable {

        fun getGroups(): Array<String> =
                this.groups.replace("\\s".toRegex(), "").split(",").toTypedArray()
}