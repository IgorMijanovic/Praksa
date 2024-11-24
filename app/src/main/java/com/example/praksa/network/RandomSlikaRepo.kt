package com.example.praksa.network

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.example.praksa.network.model.RandomSlika
import javax.inject.Inject

class RandomSlikaRepo @Inject constructor(
    private val randomSlikaService: RandomSlikaService
){
    suspend fun getRandomSliku(): Bitmap? {
        var bmp = BitmapFactory.decodeStream(randomSlikaService.GetRandomSlika().body()!!.byteStream());
        return bmp
    }
}