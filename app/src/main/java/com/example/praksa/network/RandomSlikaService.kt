package com.example.praksa.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET

interface RandomSlikaService {

///https://dummyimage.com/

    //mora da zna koji tip podatka da je png i kako da ga obradi u png, znaci fali
    // jos jedan korak izmedju da razume sa cime treba da tadi
    @GET("600x400/ffffff/202dd9.png&text=test")
    suspend fun GetRandomSlika(): Response<ResponseBody> ///Response<Stream>
}