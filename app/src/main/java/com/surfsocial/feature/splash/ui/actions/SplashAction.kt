package com.surfsocial.feature.splash.ui.actions

import androidx.navigation.NavHostController
import com.surfsocial.feature.main.ui.route.MainScreenRoute

interface SplashActions {

    val controller: NavHostController

    fun navigateToMain() {
        controller.navigate(MainScreenRoute.value)
    }
}