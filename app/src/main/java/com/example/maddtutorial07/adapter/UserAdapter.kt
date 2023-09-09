package com.example.maddtutorial07.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.maddtutorial07.R
import com.example.maddtutorial07.database.User

class UserAdapter(val data:List<User>):RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view:View = layoutInflater.inflate(R.layout.list_item,parent,false)
        val userViewHolder = UserViewHolder(view)

        return userViewHolder
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val singleData = data[position].userName
        holder.tvItem.text = singleData

        holder.tvItem.setOnClickListener{

        }
    }
}