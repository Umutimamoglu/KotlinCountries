package com.hope.kotlincountries.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Country(
    @ColumnInfo(name = "name")
    @SerializedName("name")
    val countryName: String?,
    @ColumnInfo(name = "Region")
    @SerializedName("Region")
    val countryRegion: String?,
    @ColumnInfo(name = "capital")
    @SerializedName("capital")
    val countryCapital: String?,
    @ColumnInfo(name = "currency")
    @SerializedName("currency")
    val countryCurrency: String?,
    @ColumnInfo(name = "language")
    @SerializedName("language")
    val countryLanguage: String?,
    @ColumnInfo(name = "flag")
    @SerializedName("flag")
    val imageUrl: String?,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uuid")
    var uuid: Int = 0
)



















