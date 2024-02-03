package com.hope.kotlincountries.service

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.hope.kotlincountries.model.Country
@Dao
interface CountryDao {

    @Insert
    suspend fun insertAll(vararg countries: Country) : List<Long>
    //suspend -> corotuine, pause & resume
    // vararg -> multiple country object
    // list<Long>  -> primary Keys

    @Query("SELECT * FROM country")
    suspend fun getAllCountries() : List<Country>

    @Query("SELECT * FROM country WHERE uuid = :countryId")
    suspend fun  getCountry(countryId : Int): Country

    @Query("DELETE FROM country")
    suspend fun deleteAllCountries()





































}