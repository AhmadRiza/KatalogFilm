package riza.example.katalogfilm.api

import retrofit2.Call
import retrofit2.http.GET
import riza.example.katalogfilm.model.NowPlayingResponse

/**
 * Created by riza@deliv.co.id on 10/7/19.
 */

interface MyAPI{

    @GET("movie/now_playing?api_key=dd73c5ac502e197e2cd077beb32431e7")
    fun getNowPlaying():Call<NowPlayingResponse>

}