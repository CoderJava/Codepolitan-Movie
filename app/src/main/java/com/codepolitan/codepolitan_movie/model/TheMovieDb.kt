package com.codepolitan.codepolitan_movie.model

import com.google.gson.annotations.SerializedName


/**
 * Created by yudisetiawan on 11/4/17.
 */

data class TheMovieDb(
		@SerializedName("results") val results: List<Result>,
		@SerializedName("page") val page: Int,
		@SerializedName("total_results") val totalResults: Int,
		@SerializedName("dates") val dates: Dates,
		@SerializedName("total_pages") val totalPages: Int
)


