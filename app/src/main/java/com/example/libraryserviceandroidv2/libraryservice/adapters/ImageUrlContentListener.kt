package com.example.libraryserviceandroidv2.libraryservice.adapters

import android.os.Build
import android.view.ContentInfo
import android.view.OnReceiveContentListener
import android.view.View
import android.widget.ImageView
import androidx.annotation.RequiresApi
import com.example.libraryserviceandroidv2.R

@RequiresApi(Build.VERSION_CODES.S)
class ImageUrlContentListener : OnReceiveContentListener {
    override fun onReceiveContent(view: View, payload: ContentInfo): ContentInfo? {

        view.findViewById<ImageView>(R.id.image)

        return null
    }
}