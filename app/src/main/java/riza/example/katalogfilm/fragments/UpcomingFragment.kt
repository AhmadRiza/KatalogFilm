package riza.example.katalogfilm.fragments


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_movie.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import riza.example.katalogfilm.DetailActivity

import riza.example.katalogfilm.R
import riza.example.katalogfilm.adapter.MovieAdapter
import riza.example.katalogfilm.adapter.MovieListener
import riza.example.katalogfilm.api.MyClient
import riza.example.katalogfilm.model.Film
import riza.example.katalogfilm.model.MovieResponse


class UpcomingFragment : Fragment(), MovieListener {

    override fun onClick(position: Int, movie: Film) {

        val intent = Intent(context, DetailActivity::class.java)

        intent.putExtra("movie", movie)

        startActivity(
            intent
        )

    }

    private lateinit var movieAdapter : MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        do anything
        setView()
        loadMovie()

    }

    private fun loadMovie(){

        swipe?.isRefreshing = true

        MyClient.myApiClient()
            .getUpcoming()
            .enqueue(object : Callback<MovieResponse> {

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

                    //kodingan kalo gagal
                    Toast.makeText(context, t.message, Toast.LENGTH_SHORT).show()

                }

                override fun onResponse(
                    call: Call<MovieResponse>,
                    response: Response<MovieResponse>
                ) {
                    //kodingan kalo sukses
                    if(response.isSuccessful){

                        response.body()?.let {

                            movieAdapter.updateData(it.results)

                        }

                        swipe?.isRefreshing = false

                    }
                }

            })


    }


    private fun setView(){

        swipe?.setOnRefreshListener {

            loadMovie()

        }

        movieAdapter = MovieAdapter(this)

        rv_movie?.apply {

            layoutManager = LinearLayoutManager(context)

            adapter = movieAdapter

        }

    }

}
