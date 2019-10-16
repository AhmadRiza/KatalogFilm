package riza.example.katalogfilm.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * Created by riza@deliv.co.id on 10/7/19.
 */

data class MovieResponse(
    @SerializedName("results") val results: ArrayList<Film>
)

@Parcelize
@Entity
data class Film(
    @PrimaryKey @SerializedName("id") val id: Int,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("backdrop_path") val backPath: String,
    @SerializedName("title") val title: String,
    @SerializedName("vote_average") val voteAvg: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("release_date") val releaseDate: String
):Parcelable
