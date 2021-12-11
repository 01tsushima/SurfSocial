package com.surfsocial.feature.splash.ui.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.surfsocial.base.navigation.NavActions
import com.surfsocial.feature.splash.ui.SplashScreen
import com.surfsocial.feature.splash.ui.navigation.route.SplashScreenRoute

fun NavGraphBuilder.splashScreenNav(
    navAction: NavActions
) {
    composable(SplashScreenRoute.value) {
        SplashScreen{
            navAction.navigateToMain()
        }
    }
}