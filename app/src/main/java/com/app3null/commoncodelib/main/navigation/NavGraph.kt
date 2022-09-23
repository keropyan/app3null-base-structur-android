package com.app3null.commoncodelib.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app3null.commoncodelib.consts.Screens
import com.app3null.commoncodelib.main.details.DetailsScreen
import com.app3null.commoncodelib.main.welcome.WelcomeScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.WELCOME
    ) {

        composable(
            route = Screens.WELCOME,
        ) {
            WelcomeScreen(
                onClickToDetailScreen = { navController.navigate(Screens.DETAILS) }
            )
        }
        composable(
            route = Screens.DETAILS,
        ) {
            DetailsScreen()
        }
    }
}