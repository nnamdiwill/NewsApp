package com.example.news_then_and_now

import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
import android.content.pm.ActivityInfo.SCREEN_ORIENTATION_SENSOR
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.news_then_and_now.nav.NewsInfoNavHost
import com.example.news_then_and_now.prefs.NewsPrefs
import com.example.news_then_and_now.ui.theme.News_Then_And_NowTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var prefs: NewsPrefs

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            prefs.getRotationEnabled()
                .collect { rotationEnabled ->
                    requestedOrientation = if (rotationEnabled) {
                        SCREEN_ORIENTATION_SENSOR
                    } else {
                        SCREEN_ORIENTATION_PORTRAIT
                    }
                }
        }
        setContent {
            News_Then_And_NowTheme {
                NewsInfoNavHost()
            }
        }
    }
}






