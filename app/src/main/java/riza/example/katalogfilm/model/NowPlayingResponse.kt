package riza.example.katalogfilm.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by riza@deliv.co.id on 10/7/19.
 */

data class NowPlayingResponse(
    @SerializedName("results") val results: ArrayList<Film>
)

@Parcelize
data class Film(
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("backdrop_path") val backPath: String,
    @SerializedName("title") val title: String,
    @SerializedName("vote_average") val voteAvg: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("release_date") val releaseDate: String
):Parcelable


