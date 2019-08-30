package com.assignment.myresume.di

import com.assignment.myresume.MyResumeApplication
import com.google.gson.FieldNamingPolicy
import dagger.Provides
import retrofit2.Retrofit
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

class ApiModule(
    private val baseUrl: String
) {

    @Provides
    @Singleton
    fun provideCache(application: MyResumeApplication): Cache {
        // 1024 byte = 1KB X 1024 = 1MB X 10 = 10MB
        val cacheSize = 10 * 1024 * 1024L
        return Cache(application.cacheDir, cacheSize)
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().apply {
            setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        }.create()

    }

    @Provides
    @Singleton
    fun provideOkHttp(cache: Cache): OkHttpClient {
        return OkHttpClient.Builder().apply {
            cache(cache)
        }.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder().apply {
            baseUrl(baseUrl)
            addConverterFactory(GsonConverterFactory.create(gson))
            client(okHttpClient)
        }.build()
    }
}