package com.example.news_then_and_now.nav


import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost


import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.news_then_and_now.ui.theme.screens.FirstScreen
import com.example.news_then_and_now.ui.theme.screens.about.AboutScreen
import com.example.news_then_and_now.ui.theme.screens.newsDetails.NewsDetailScreen
import com.example.news_then_and_now.ui.theme.screens.newsDetails.NewsDetailViewModel
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

        /*
        fun NewsListScreen(
            viewModel: NewsListViewModel,
            onNewsRowTap: (newsIndex: Int) -> Unit,
            onSettingsTap: () -> Unit,
            onAboutTap: () -> Unit,
        ) {
         */
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
            /*
            fun NewsDetailScreen(

    viewModel: NewsDetailViewModel,
    onNavigateUp: () -> Unit,
) {
             */
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
    /*
    fun CountryInfoNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.List.path) {
        composable(Screen.List.path) {
            CountryListScreen(
                viewModel = hiltViewModel(),
                onCountryRowTap = { countryIndex ->
                    navController.navigate("${Screen.Details.path}/$countryIndex")
                },
                onSettingsTap = { navController.navigate(Screen.Settings.path) },
                onAboutTap = { navController.navigate(Screen.About.path) },
            )
        }

        composable(
            route = "${Screen.Details.path}/{countryIndex}",
            arguments = listOf(navArgument("countryIndex") { type = NavType.IntType }),
        ) { backStackEntry ->
            val countryIndex = backStackEntry.arguments!!.getInt("countryIndex")
            CountryDetailsScreen(
                countryIndex = countryIndex,
                viewModel = hiltViewModel(),
                onNavigateUp = { navController.navigateUp() },
            )
        }

        composable(Screen.About.path) {
            AboutScreen(
                onNavigateUp = { navController.navigateUp() },
            )
        }

        composable(Screen.Settings.path) {
            SettingsScreen(
                viewModel = hiltViewModel(),
                onNavigateUp = { navController.navigateUp() },
            )
        }
    }
}
     */

