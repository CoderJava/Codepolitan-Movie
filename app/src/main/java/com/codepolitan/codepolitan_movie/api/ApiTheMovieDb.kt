package com.codepolitan.codepolitan_movie.api

import com.codepolitan.codepolitan_movie.BuildConfig
import com.codepolitan.codepolitan_movie.model.TheMovieDb
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by yudisetiawan on 11/4/17.
 */

interface ApiTheMovieDb {

    @GET("movie/now_playing")
    fun getNowPlaying(
            @Query("api_key") apiKey: String = BuildConfig.API_KEY,
            @Query("language") language: String = BuildConfig.LANGUAGE,
            @Query("page") page: Int
    ): Observable<TheMovieDb>
}