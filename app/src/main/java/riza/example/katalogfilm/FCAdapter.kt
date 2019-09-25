package riza.example.katalogfilm

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_fc.view.*
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * Created by riza@deliv.co.id on 9/25/19.
 */


class FCAdapter : RecyclerView.Adapter<FCVH>() {




    private val mData = arrayListOf<FC>()


    fun updateData(data: ArrayList<FC>) {
        mData.addAll(data)
        notifyDataSetChanged()
    }

    fun addData(movie: FC){
        mData.add(movie)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FCVH {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_movie, parent, false)

        return FCVH(view)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    override fun onBindViewHolder(holder: FCVH, position: Int) {
        holder.bind(mData[position])
    }

}

class FCVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(data: FC) {

        itemView.tv_stad

    }

}