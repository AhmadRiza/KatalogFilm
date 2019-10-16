package riza.example.katalogfilm.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.item_movie.view.*
import riza.example.katalogfilm.model.Film
import riza.example.katalogfilm.R

/**
 * Created by riza@deliv.co.id on 9/25/19.
 */


class MovieAdapter(val listener: MovieListener) : RecyclerView.Adapter<MovieVH>() {


    private val mData = arrayListOf<Film>()

    fun updateData(data: ArrayList<Film>) {
        mData.clear()
        mData.addAll(data)
        notifyDataSetChanged()
    }

    fun addData(movie: Film){
        mData.add(movie)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieVH {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_movie, parent, false)

        return MovieVH(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: MovieVH, position: Int) {
        holder.bind(mData[position], listener)
    }

}

class MovieVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(data: Film, listener: MovieListener) {

        itemView.tv_title?.text = data.title
        itemView.tv_year?.text = data.releaseDate
        itemView.tv_detail?.text = data.overview
        itemView.tv_rating?.text = data.voteAvg
        itemView.img_poster?.apply {

            //load gambar
            Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500"+data.posterPath)
                .into(this)


        }


        itemView.rootView.setOnClickListener {

            listener.onClick(adapterPosition, data)

        }
    }

}


interface MovieListener{

    fun onClick(position: Int, movie: Film)

}