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

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        val title = intent.getStringExtra("title")
        val year = intent.getStringExtra("year")
        val detail = intent.getStringExtra("detail")
        val poster = intent.getStringExtra("poster")
        val rate = intent.getStringExtra("rating")


        tv_title?.text = title
        tv_year?.text = year
        tv_rating?.text = rate
        tv_detail?.text = detail
        img_poster?.apply {

            Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500$poster")
                .into(this)

        }


        setUpToolbar(title)

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
}
