package com.example.news_then_and_now.di

import android.content.Context
import com.example.news_then_and_now.NewsService
import com.example.news_then_and_now.databases.CurrentDatabase
import com.example.news_then_and_now.prefs.NewsPrefs
import com.example.news_then_and_now.prefs.NewsPrefsImpl
import com.example.news_then_and_now.repositories.NewsRepository
import com.example.news_then_and_now.repositories.NewsRepositoryImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NewsInfoModule {

    @Provides
    @Singleton
    fun provideNewsService(): NewsService {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://api.mediastack.com/v1/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()

        return retrofit.create(NewsService::class.java)

    }


    @Provides
    @Singleton
    fun provideNewsDatabase(@ApplicationContext applicationContext: Context): CurrentDatabase {
        return CurrentDatabase.buildDatabase(applicationContext)
    }


    @Provides
    @Singleton
    fun provideNewsPrefs(@ApplicationContext applicationContext: Context): NewsPrefs {
        return NewsPrefsImpl(applicationContext)
    }


    @Provides
    @Singleton
    fun providesNewsRepository(
        service: NewsService,
        database: CurrentDatabase,
    ): NewsRepository = NewsRepositoryImpl(service, database.newsDao(),prefs)

}