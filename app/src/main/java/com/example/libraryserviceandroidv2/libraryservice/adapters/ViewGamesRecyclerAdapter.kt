package com.example.libraryserviceandroidv2.libraryservice.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.libraryserviceandroidv2.R
import com.example.libraryserviceandroidv2.libraryservice.model.games.GameModel
import com.squareup.picasso.Picasso

class ViewGamesRecyclerAdapter(val userList: List<GameModel>) : RecyclerView.Adapter<ViewGamesRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.cardviewlayout, p0, false)
        return ViewHolder(v);
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        var iGameText = p0.itemView.findViewById<TextView>(R.id.gameNameText)
        var iGamePlatform = p0.itemView.findViewById<TextView>(R.id.gamePlatformText)
        var iGameGenre = p0.itemView.findViewById<TextView>(R.id.gameGenreText)
        var iGameReleaseDate = p0.itemView.findViewById<TextView>(R.id.gameReleaseDateText)
        var iGameRatingBar = p0.itemView.findViewById<RatingBar>(R.id.ratingBarCard)

        iGameText.setText(userList[p1].gameName)
        iGamePlatform.setText(userList[p1].platform)
        iGameGenre.setText(userList[p1].gameGenre)
        iGameReleaseDate.setText(userList[p1].releaseDate)
        iGameRatingBar.rating = userList[p1].gameRating

        Picasso
            .get()
            .load(userList[p1].imageUrl)
            .placeholder(R.drawable.download)
            .resize(425,425)
            .into(p0.itemView.findViewById<ImageView>(R.id.gameimage))

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //val f : TextView = itemView.findViewById(R.id.gameNameText)
    }
}