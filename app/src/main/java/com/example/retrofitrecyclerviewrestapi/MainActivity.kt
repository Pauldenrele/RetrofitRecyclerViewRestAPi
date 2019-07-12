package com.example.retrofitrecyclerviewrestapi

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

   val retrofit = Retrofit.Builder()
       .baseUrl("https://app-6924d9ff-0550-4ff9-9ac7-8d6cee9c5136.cleverapps.io/")
       .addConverterFactory(GsonConverterFactory.create())
       .build()

        val api = retrofit.create(ApiService::class.java)

        api.fetchCategories().enqueue(object :Callback<List<User>>{
            override fun onFailure(call: Call<List<User>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                showData(response.body())
              }

        })
        val users = mutableListOf<User>()

        for (i in 1..100){
            users.add(User("Paul", "John"))
        }


    }

    private fun showData(users: List<User>?) {
        recyclerview.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = UsersAdapter(users!!)
        }
    }
}
