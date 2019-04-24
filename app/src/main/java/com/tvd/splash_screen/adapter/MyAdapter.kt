package com.tvd.splash_screen.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import com.tvd.splash_screen.R
import com.tvd.splash_screen.models.Movies
import kotlinx.android.synthetic.main.inflate_list.view.*
import org.jetbrains.anko.toast

class MyAdapter (val list : List<Movies>, val context:Context):RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.inflate_list, parent, false)
        return MyViewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvName.text = "Name : " + list.get(position).original_title
        holder.tvId.text = "Id : " + list.get(position).id.toString()
        holder.tvDesc.text = "Desc : " + list.get(position).overview
        holder.tvDate.text = "Release Date : " + list.get(position).release_date
       // holder.tvPoster.text = "Poster Path : " + list.get(position).poster_path

        Picasso.get()
            .load("https://i.imgur.com/jXokAsP.png")
            .fit()
            .into(holder.tvImage)

        holder.itemView.setOnClickListener {
            context.toast(list.get(position).original_title)
        }
    }

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val tvName = itemView.tvName
        val tvId = itemView.tvId
        val tvDesc = itemView.tvDesc
        val tvDate = itemView.tvDate
        //val tvPoster = itemView.tvPosterPath
        val tvImage = itemView.tvMovieimage
    }
}