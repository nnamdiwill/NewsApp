package com.example.news_then_and_now.nav


import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.news_then_and_now.ui.theme.screens.FirstScreen
import com.example.news_then_and_now.ui.theme.screens.about.AboutScreen
import com.example.news_then_and_now.ui.theme.screens.newsDetails.NewsDetailScreen
import com.example.news_then_and_now.ui.theme.screens.newsList.NewsListScreen
import com.example.news_then_and_now.ui.theme.screens.settings.SettingsScreen


@Composable
fun NewsInfoNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = FirstScreen.List.path ) {
        composable(FirstScreen.List.path) {
            NewsListScreen(
                viewModel = hiltViewModel(),
                onNewsRowTap = { newsIndex ->
                    navController.navigate("${FirstScreen.Details.path}/$newsIndex")
                },
                onSettingsTap = { navController.navigate(FirstScreen.Settings.path) },
                onAboutTap = { navController.navigate(FirstScreen.About.path) },
            )
        }


        composable(
            route = "${FirstScreen.Details.path}/{newsIndex}",
            arguments = listOf(navArgument("newsIndex") { type = NavType.IntType }),
        ) { backStackEntry ->
            val newsIndex = backStackEntry.arguments!!.getInt("newsIndex")
            NewsDetailScreen(
                newsIndex = newsIndex,
                viewModel = hiltViewModel(),
                onNavigateUp = { navController.navigateUp() },
            )

        }
        composable(FirstScreen.About.path) {
            AboutScreen(
                onNavigateUp = { navController.navigateUp() },
            )
        }

        composable(FirstScreen.Settings.path) {
            SettingsScreen(
                viewModel = hiltViewModel(),
                onNavigateUp = { navController.navigateUp() },
            )
        }
    }

    }
