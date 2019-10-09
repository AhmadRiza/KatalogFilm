package riza.example.katalogfilm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_rv.*
import kotlinx.android.synthetic.main.activity_rv.toolbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import riza.example.katalogfilm.adapter.MovieAdapter
import riza.example.katalogfilm.adapter.MovieListener
import riza.example.katalogfilm.api.MyClient
import riza.example.katalogfilm.model.Film
import riza.example.katalogfilm.model.Movie
import riza.example.katalogfilm.model.NowPlayingResponse

class RVActivity : AppCompatActivity(), MovieListener {

    override fun onClick(position: Int, movie: Film) {

        val intent = Intent(this, DetailActivity::class.java)

        intent.putExtra("title", movie.title)
        intent.putExtra("detail", movie.overview)
        intent.putExtra("year", movie.releaseDate)
        intent.putExtra("poster", movie.backPath)
        intent.putExtra("rating", movie.voteAvg)

        startActivity(
            intent
        )

    }

    private lateinit var movieAdapter : MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rv)

        setView()
        loadMovie()
        setUpToolbar("Beranda")
    }

    private fun loadMovie(){

        MyClient.myApiClient()
            .getNowPlaying()
            .enqueue(object : Callback<NowPlayingResponse> {

                override fun onFailure(call: Call<NowPlayingResponse>, t: Throwable) {

                    //kodingan kalo gagal
                    Toast.makeText(this@RVActivity, t.message, Toast.LENGTH_SHORT).show()

                }

                override fun onResponse(
                    call: Call<NowPlayingResponse>,
                    response: Response<NowPlayingResponse>
                ) {
                    //kodingan kalo sukses
                    if(response.isSuccessful){

                        response.body()?.let {

                            movieAdapter.updateData(it.results)

                        }

                    }
                }

            })


    }


    private fun setView(){

        movieAdapter = MovieAdapter(this)

        rv_movie?.apply {

            layoutManager = LinearLayoutManager(context)

            adapter = movieAdapter

        }

    }

    private fun setUpToolbar(title: String){

        setSupportActionBar(toolbar) // set toolbar
        supportActionBar?.title = title //set title

    }

}
