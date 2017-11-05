package com.codepolitan.codepolitan_movie.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.codepolitan.codepolitan_movie.BuildConfig
import com.codepolitan.codepolitan_movie.R
import com.codepolitan.codepolitan_movie.model.Result
import kotlinx.android.synthetic.main.item_movie.view.*

/**
 * Created by yudisetiawan on 11/4/17.
 */
class AdapterTheMovieDb(private val context: Context, private var resultTheMovieDb: ArrayList<Result>) : RecyclerView.Adapter<AdapterTheMovieDb.ViewHolderTheMovieDb>() {

    private val TAG = javaClass.simpleName

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolderTheMovieDb =
            ViewHolderTheMovieDb(LayoutInflater
                    .from(parent?.context)
                    .inflate(R.layout.item_movie, parent, false)
            )

    override fun onBindViewHolder(holder: ViewHolderTheMovieDb?, position: Int) {
        val resultItem = resultTheMovieDb[position]
        Glide
                .with(context)
                .load(BuildConfig.BASE_URL_IMAGE + resultItem.posterPath)
                .into(holder?.itemView?.image_view_poster_item_movie)
        holder
                ?.itemView
                ?.text_view_title_movie_item_movie
                ?.text = resultItem.originalTitle
        holder
                ?.itemView
                ?.text_view_vote_average_item_movie
                ?.text = resultItem.voteAverage.toString()
        holder
                ?.itemView
                ?.text_view_release_date_value_item_movie
                ?.text = resultItem.releaseDate
        holder
                ?.itemView
                ?.text_view_overview_value_item_movie
                ?.text = resultItem.overview
    }

    override fun getItemCount(): Int = resultTheMovieDb.size

    fun refreshAdapter(resultTheMovieDb: List<Result>) {
        this.resultTheMovieDb.addAll(resultTheMovieDb)
        notifyItemRangeChanged(0, this.resultTheMovieDb.size)
    }

    inner class ViewHolderTheMovieDb(itemView: View?) : RecyclerView.ViewHolder(itemView)

}