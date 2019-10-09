package riza.example.katalogfilm.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by riza@deliv.co.id on 10/7/19.
 */

object MyClient {

    val  retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org/3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun myApiClient() = retrofit.create(MyAPI::class.java)

}

