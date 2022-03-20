package com.example.libraryserviceandroidv2.libraryservice.activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryserviceandroidv2.R
import com.example.libraryserviceandroidv2.libraryservice.database.entity.GameEntity

class ViewGamesRecyclerAdapter(val userList: List<GameEntity>) : RecyclerView.Adapter<ViewGamesRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.cardviewgameslayout, p0, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}