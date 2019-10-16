package riza.example.katalogfilm.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import riza.example.katalogfilm.model.Film

/**
 * Created by riza@deliv.co.id on 10/16/19.
 */

@Database(entities = [Film::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao
}


object AppDB{

    fun getDB(context: Context) = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "filmDB"
    )
        .allowMainThreadQueries()
        .build()

}