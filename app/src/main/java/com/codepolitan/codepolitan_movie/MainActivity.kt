package com.codepolitan.codepolitan_movie

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.codepolitan.codepolitan_movie.adapter.AdapterTheMovieDb
import com.codepolitan.codepolitan_movie.api.ApiTheMovieDb
import com.codepolitan.codepolitan_movie.model.TheMovieDb
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val TAG = javaClass.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        doLoadData()
    }

    private fun doLoadData() {
        showLoading()
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
        val apiTheMovieDb = retrofit.create(ApiTheMovieDb::class.java)
        apiTheMovieDb.getNowPlaying(page = 1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            theMovieDb: TheMovieDb ->
                            val resultTheMovieDb = theMovieDb.results;
                            var adapterTheMovieDb = AdapterTheMovieDb(
                                    this@MainActivity,
                                    resultTheMovieDb
                            )
                            recycler_view_movie_activity_main.layoutManager = LinearLayoutManager(this@MainActivity)
                            recycler_view_movie_activity_main.adapter = adapterTheMovieDb
                        },
                        {
                            t: Throwable ->
                            t.printStackTrace()
                        },
                        {
                            hideLoading()
                        }
                )
    }

    private fun showLoading() {
        progress_bar_horizontal_activity_main.visibility = View.VISIBLE
        recycler_view_movie_activity_main.visibility = View.GONE
    }

    private fun hideLoading() {
        progress_bar_horizontal_activity_main.visibility = View.GONE
        recycler_view_movie_activity_main.visibility = View.VISIBLE
    }

}
