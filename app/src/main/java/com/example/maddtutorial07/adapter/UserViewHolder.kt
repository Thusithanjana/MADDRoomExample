package com.example.maddtutorial07.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.maddtutorial07.R

class UserViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
    val tvItem:TextView = itemView.findViewById(R.id.tvItem)
}