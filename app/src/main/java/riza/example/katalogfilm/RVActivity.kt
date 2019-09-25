package riza.example.katalogfilm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_rv.*

class RVActivity : AppCompatActivity() {

    private lateinit var movieAdapter : MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv)

        setView()

    }


    fun setView(){

        movieAdapter = MovieAdapter()

        rv_movie?.apply {

            layoutManager = LinearLayoutManager(context)

            adapter = movieAdapter

        }

        val data = arrayListOf<Movie>(

            Movie("Endgame", "2019", "Lorem Ipsum",R.drawable.endgame),
            Movie("Endgame", "2019", "Lorem Ipsum",R.drawable.spongebob)
        )

        movieAdapter.updateData(data)
        movieAdapter.addData( Movie("Captain Marvel", "2019", "Lorem Ipsum",R.drawable.spongebob))
    }

}
