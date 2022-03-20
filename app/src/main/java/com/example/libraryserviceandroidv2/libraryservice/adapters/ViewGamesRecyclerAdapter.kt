package com.example.libraryserviceandroidv2.libraryservice.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryserviceandroidv2.R
import com.example.libraryserviceandroidv2.libraryservice.database.entity.GameEntity

class ViewGamesRecyclerAdapter(val userList: List<GameEntity>) : RecyclerView.Adapter<ViewGamesRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.cardviewlayout, p0, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        var iGameText = p0.itemView.findViewById<TextView>(R.id.gameNameText)

        iGameText.setText(userList[p1].gameName)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //val f : TextView = itemView.findViewById(R.id.gameNameText)
    }
}