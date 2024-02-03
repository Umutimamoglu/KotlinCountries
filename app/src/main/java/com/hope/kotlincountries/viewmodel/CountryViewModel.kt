package com.hope.kotlincountries.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hope.kotlincountries.model.Country
import com.hope.kotlincountries.service.CountryDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CountryViewModel(application: Application) :BaseViewModel(application) {
    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom(uuid: Int) {
        // Coroutine başlat
        viewModelScope.launch {
            val dao = CountryDatabase(getApplication()).countryDao()

            // Veritabanı işlemleri için IO dispatcher'a geçmek için withContext kullan
            val country = withContext(Dispatchers.IO) {
                dao.getCountry(uuid)
            }

            countryLiveData.value = country
        }
    }
}