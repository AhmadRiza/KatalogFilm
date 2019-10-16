package riza.example.katalogfilm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.item_movie.*
import kotlinx.android.synthetic.main.item_movie.img_poster
import kotlinx.android.synthetic.main.item_movie.tv_detail
import kotlinx.android.synthetic.main.item_movie.tv_rating
import kotlinx.android.synthetic.main.item_movie.tv_title
import kotlinx.android.synthetic.main.item_movie.tv_year
import riza.example.katalogfilm.data.AppDB
import riza.example.katalogfilm.model.Film
import riza.example.katalogfilm.model.Movie

class DetailActivity : AppCompatActivity() {

    private lateinit var movie: Film

    private val db by lazy { AppDB.getDB(this).movieDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        movie = intent.getParcelableExtra("movie")!!

        tv_title?.text = movie.title
        tv_year?.text = movie.releaseDate
        tv_rating?.text = movie.voteAvg
        tv_detail?.text = movie.overview
        img_poster?.apply {

            Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500${movie.backPath}")
                .into(this)

        }


        setUpToolbar(movie.title)

        setFavButton()

    }


    private fun setUpToolbar(title: String){

        setSupportActionBar(toolbar) // set toolbar
        supportActionBar?.title = title //set title

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return super.onSupportNavigateUp()
    }

    fun setFavButton(){

        //check if movie di dalam db / tidak
        val foundFilm = db.getMovieWithID(movie.id)

        if(foundFilm == null){
            fab.setImageResource(R.drawable.ic_favorite_border)

            fab.setOnClickListener {
                db.insertAll(movie)
                setFavButton()
            }
        }else{
            fab.setImageResource(R.drawable.ic_favorite_white)

            fab.setOnClickListener {
                db.delete(movie)
                setFavButton()
            }

        }

    }


}
