package com.hope.kotlincountries.service

import com.hope.kotlincountries.model.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountryAPI {
    @GET("atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json")
    fun getCountries():Single<List<Country>>

    //https://raw.githubusercontent.com/atilsamancioglu/IA19-DataSetCountries/master/countrydataset.json
}