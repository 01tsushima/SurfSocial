package com.surfsocial.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.google.accompanist.pager.ExperimentalPagerApi
import com.surfsocial.base.navigation.NavActions
import com.surfsocial.feature.main.ui.navigation.mainScreenNav
import com.surfsocial.feature.splash.ui.navigation.route.SplashScreenRoute
import com.surfsocial.feature.splash.ui.navigation.splashScreenNav

@ExperimentalPagerApi
@Composable
fun NavGraph(
    navController: NavHostController
) {
    val navActions = remember(navController) {
        NavActions(navController)
    }

    NavHost(navController = navController, startDestination = SplashScreenRoute.value) {
        splashScreenNav(navActions)
        mainScreenNav(navActions)
    }
}