package com.tvd.splash_screen.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.tvd.splash_screen.R
import com.tvd.splash_screen.adapter.MyAdapter
import com.tvd.splash_screen.models.MovieResponse
import com.tvd.splash_screen.models.Movies
import com.tvd.splash_screen.rest.APIClient
import com.tvd.splash_screen.rest.ApiInterface
import kotlinx.android.synthetic.main.activity_movie.*
import org.jetbrains.anko.toast

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieActivity : AppCompatActivity() {
    val API_KEY: String = "ec44357d71b936de6ee7f5aa7837b6a4"
    lateinit var myCustomAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie)

        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)

        if (API_KEY.isEmpty()){
            toast("Please obtain your API KEY first from www.themoviedb.org")
            return
        }
        progressBar.visibility =View.VISIBLE
        var apiService = APIClient.client.create(ApiInterface::class.java)

        val call = apiService.getTopRatedMovies(API_KEY)
        call.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {

                var listOfMovies: List<Movies> = response.body()?.results!!
                myCustomAdapter = MyAdapter(listOfMovies, applicationContext)
                recyclerview.setAdapter(myCustomAdapter)
                progressBar.visibility = View.GONE
            }

            override fun onFailure(call: Call<MovieResponse>?, t: Throwable?) {
                progressBar.visibility = View.GONE
                Log.d("debug", t.toString())
            }
        })
    }
}
