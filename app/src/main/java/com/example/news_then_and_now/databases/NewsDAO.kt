package com.example.news_then_and_now.databases


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.news_then_and_now.dataclasses.CurrentNews



@Dao
interface NewsDAO{

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun getNews(currentNews: CurrentNews)

    @Query("SELECT * FROM currentnews WHERE author = :author")
    suspend fun findHeadLineByAuthorName(author: String): CurrentNews

    @Query("SELECT * FROM currentnews")
    suspend fun getAllNewsHeadLines(): List<CurrentNews>

    @Delete
    suspend fun deleteNewsHeadLine(currentNews: CurrentNews)

    @Query("DELETE FROM currentnews")
    suspend fun deleteCurrentNews()

}
