package com.example.retrofitrecyclerviewrestapi

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.user_row.view.*

class UsersAdapter ( private val posts:List<Post>) :RecyclerView.Adapter<UsersAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): UsersAdapter.ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.user_row  , p0 , false)
 return ViewHolder(view)
         }

    override fun getItemCount() = posts.size

    override fun onBindViewHolder(p0: UsersAdapter.ViewHolder, p1: Int) {
       // val user = users[p1]
        val post = posts[p1]
        Log.d("Love", "UserResponce ${post.title}")

       // p0.categoriesName.text =user.categories
        p0.categoriesName.text = post.title
      //  p0.categoriesName.append(user.categories)
        }

    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val categoriesName :TextView = itemView.categoriesName

    }




}