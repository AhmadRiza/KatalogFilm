package riza.example.katalogfilm.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import riza.example.katalogfilm.model.Film

/**
 * Created by riza@deliv.co.id on 10/16/19.
 */

@Dao
interface MovieDao {

    @Insert
    fun insertAll(vararg movie: Film)

    @Delete
    fun delete(movie: Film)

    @Query("SELECT * FROM Film")
    fun getAllMovies(): List<Film>

    @Query("SELECT * FROM Film WHERE id = :idMovie LIMIT 1")
    fun getMovieWithID(idMovie: Int): Film?

}