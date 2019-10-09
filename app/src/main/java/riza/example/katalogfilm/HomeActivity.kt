package riza.example.katalogfilm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_rv.*
import riza.example.katalogfilm.fragments.MovieFragment

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mycontainer, MovieFragment())
            .commit()

     supportFragmentManager
                .beginTransaction()
                .replace(R.id.mycontainer2, MovieFragment())
                .commit()

        setUpToolbar("Home")

    }

    private fun setUpToolbar(title: String){

        setSupportActionBar(toolbar) // set toolbar
        supportActionBar?.title = title //set title

    }

}
