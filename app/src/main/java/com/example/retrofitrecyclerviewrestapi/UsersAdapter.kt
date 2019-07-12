package com.example.retrofitrecyclerviewrestapi

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.user_row.view.*

class UsersAdapter (private val users:List<User> ) :RecyclerView.Adapter<UsersAdapter.ViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): UsersAdapter.ViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.user_row  , p0 , false)
 return ViewHolder(view)
         }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(p0: UsersAdapter.ViewHolder, p1: Int) {
        val user = users[p1]
        p0.categoriesName.text =user.categories
        }

    class ViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        val categoriesName :TextView = itemView.categoriesName
    }




}