package com.example.retrofitrecyclerviewrestapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.util.Log.d
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private var list: ArrayList<Post> = ArrayList()
    private val mAdapter = UsersAdapter(list)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

   val retrofit = Retrofit.Builder()
       .baseUrl("https://app-6924d9ff-0550-4ff9-9ac7-8d6cee9c5136.cleverapps.io")
       .addConverterFactory(GsonConverterFactory.create())
       .build()

        val api = retrofit.create(ApiService::class.java)

        api.fetchCategories().enqueue(object :Callback<List<Post>>{
            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {

                Log.d("Love", "UserResponce ${response.body()!![0].title}")

              showData(response.body()!!)
                //setupRecyclerView()



              }

        })
        val users = mutableListOf<Post>()




    }

    private fun showData(users: List<Post>) {
        recyclerview.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = UsersAdapter(users)
        }


    }


    private fun showPost(posts: List<Post>) {
        recyclerview.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = UsersAdapter(posts)
        }


    }

    private fun setupRecyclerView() {
        with(recyclerview) {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = this@MainActivity.mAdapter
        }

    }

}
