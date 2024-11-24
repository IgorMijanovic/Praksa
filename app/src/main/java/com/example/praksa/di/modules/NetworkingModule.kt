package com.example.praksa.di.modules

import com.example.praksa.network.RandomSlikaService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

@Module
@InstallIn(SingletonComponent::class)
class NetworkingModule {

    @Provides
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl("https://dummyimage.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesRandomSlikuService(retrofit: Retrofit): RandomSlikaService{
        return retrofit.create(RandomSlikaService::class.java)
    }
}