package com.assignment.myresume.di

import com.assignment.myresume.BuildConfig
import com.assignment.myresume.MyResumeApplication
import com.assignment.myresume.service.ResumeService
import com.assignment.myresume.utils.Constants
import com.google.gson.FieldNamingPolicy
import dagger.Provides
import retrofit2.Retrofit
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import dagger.Module
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideCache(application: MyResumeApplication): Cache {
        // 1024 byte = 1KB X 1024 = 1MB X 10 = 10MB
        val cacheSize = 10 * 1024 * 1024L
        return Cache(application.cacheDir, cacheSize)
    }

    @Provides
    fun provideRxCallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
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
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }

    @Provides
    @Singleton
    fun provideOkHttp(cache: Cache, loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder().apply {
//            cache(cache)
            if (BuildConfig.DEBUG) addInterceptor(loggingInterceptor)
        }.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson, client: OkHttpClient, factory: RxJava2CallAdapterFactory): Retrofit {
        return Retrofit.Builder().apply {
            baseUrl(Constants.BASE_URL)
            addCallAdapterFactory(factory)
            addConverterFactory(GsonConverterFactory.create(gson))
            client(client)
        }.build()
    }

    @Provides
    @Singleton
    fun provideResumeApiService(retrofit: Retrofit): ResumeService {
        return retrofit.create(ResumeService::class.java)
    }
}