package com.example.android_movie_info_provider.ui.recycler_views.movie_adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_movie_info_provider.data.models.DailyBoxOffice
import com.example.android_movie_info_provider.databinding.MovieInfoItemBinding

class MovieAdapter(private val data: Array<DailyBoxOffice>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: MovieInfoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DailyBoxOffice) {
            binding.movieInfoTv.text = item.movieNm
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = MovieInfoItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        return holder.bind(data[position])
    }

}
