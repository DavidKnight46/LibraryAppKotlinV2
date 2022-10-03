package com.example.libraryserviceandroidv2.libraryservice.listener

import android.os.Build
import android.view.ContentInfo
import android.view.OnReceiveContentListener
import android.view.View
import android.widget.ImageView
import androidx.annotation.RequiresApi
import com.example.libraryserviceandroidv2.R
import com.squareup.picasso.Picasso

@RequiresApi(Build.VERSION_CODES.S)
class ImageUrlContentListener : OnReceiveContentListener {
    override fun onReceiveContent(view: View, payload: ContentInfo): ContentInfo? {

        Picasso
            .get()
            .load(payload.linkUri?.path)
            .placeholder(R.drawable.download)
            .resize(500, 500)
            .into(view.findViewById<ImageView>(R.id.image))

        return payload
    }
}