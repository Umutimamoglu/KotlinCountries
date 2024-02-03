package com.hope.kotlincountries.service

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hope.kotlincountries.model.Country


@Database(entities = arrayOf(Country::class), version = 1)
abstract  class CountryDatabase : RoomDatabase() {

    abstract  fun countryDao() : CountryDao

    //diğer scope lardan ulasmak için
    companion object{
        @Volatile private var instance : CountryDatabase? = null

        private  val lock = Any()

        //obje sadece bir tane thered tarafından kullanılsın
        operator fun invoke( context: Context) = instance ?: synchronized(lock) {
            instance ?: makeDatabse(context).also {
                instance = it
            }
        }

        private  fun makeDatabse(context : Context) = Room.databaseBuilder(
            context.applicationContext,CountryDatabase::class.java,"CountryDatabase"
        ).build()

    }

}



















