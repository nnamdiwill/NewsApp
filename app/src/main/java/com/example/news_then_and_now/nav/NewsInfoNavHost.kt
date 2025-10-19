package com.example.news_then_and_now.nav

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.news_then_and_now.dataclasses.CurrentNews
import com.example.news_then_and_now.models.NewsDetailScreen
import com.example.news_then_and_now.models.NewsDetailViewModel
import com.example.news_then_and_now.newsinfo.NewsInfoScreen
import com.example.news_then_and_now.newsinfo.NewsInfoViewModel
import com.example.news_then_and_now.repositories.NewsRepository


@Composable
fun NewsInfoNavHost(
    repository: NewsRepository,
    newsIndex: CurrentNews
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "list") {

        composable("list") {
            NewsInfoScreen(
                viewModel = viewModel(
                factory = NewsInfoViewModel.NewsInfoViewModelFactory(
                   // newsId = newsIndex,
                    repository = repository,
                ),
            ),
                onCurrentNewsRowTap = { newsIndex: CurrentNews ->
                    navController.navigate("details/$newsIndex")
                }
            )
        }

        composable("details/{newsIndex}",
            arguments = listOf(navArgument("countryIndex") {
                type = NavType.IntType
            })  ) {
            NewsDetailScreen(

                viewModel = viewModel(
                    factory = NewsDetailViewModel.NewsDetailsViewModelFactory(
                        newsId = it.arguments!!.getInt("newsIndex") ,
                        repository = repository,
                    ),

                    ),
                onNavigateUp = {
                    //  navController.navigateUp()
                    navController.popBackStack(
                        route = "list",
                        inclusive = false
                    )
                }

            )


        }

    }

}