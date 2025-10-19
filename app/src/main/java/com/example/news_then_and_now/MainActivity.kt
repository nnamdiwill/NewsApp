package com.example.news_then_and_now

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.news_then_and_now.dataclasses.CurrentNews
import com.example.news_then_and_now.nav.NewsInfoNavHost
import com.example.news_then_and_now.repositories.NewsRepositoryImpl
import com.example.news_then_and_now.samples.sampleNews
import com.example.news_then_and_now.ui.theme.News_Then_And_NowTheme
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val currentNews : CurrentNews = sampleNews
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.mediastack.com/")
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
        val service: NewsService = retrofit.create(NewsService::class.java)
        val currentNews: CurrentNews = sampleNews

        setContent {

            News_Then_And_NowTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Row {

                        if (currentNews != null) {
                            NewsInfoNavHost(
                                repository = NewsRepositoryImpl(service),
                                newsIndex = currentNews
                            )
                            ShowNews()
                        }

                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun ShowNews(){

    Card(modifier = Modifier) {
        currentNews
    }
}


