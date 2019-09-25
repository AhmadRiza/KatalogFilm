package riza.example.katalogfilm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * Created by riza@deliv.co.id on 9/25/19.
 */


class MovieAdapter : RecyclerView.Adapter<MovieVH>() {




    private val mData = arrayListOf<Movie>()


    fun updateData(data: ArrayList<Movie>) {
        mData.addAll(data)
        notifyDataSetChanged()
    }

    fun addData(movie: Movie){
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
        holder.bind(mData[position])
    }

}

class MovieVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(data: Movie) {

        itemView.tv_title.text = data.title
        itemView.tv_year.text = data.year
        itemView.tv_detail.text = data.detail
        itemView.img_poster.setImageResource(data.poster)

    }

}