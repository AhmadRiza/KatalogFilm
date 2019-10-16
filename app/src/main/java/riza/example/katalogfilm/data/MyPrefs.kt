package riza.example.katalogfilm.data

import android.content.Context
import androidx.core.content.edit

/**
 * Created by riza@deliv.co.id on 10/16/19.
 */

class MyPrefs (context: Context){

    private val prefs by lazy { context.getSharedPreferences("katalogfilm", 0) }


    fun saveUsername(name: String){

        prefs.edit {
            putString("name", name)
            commit()
        }

    }

    fun getUserName() = prefs.getString("name", "")!!


}