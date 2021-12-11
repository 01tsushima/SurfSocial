package com.surfsocial.base.navigation

import androidx.navigation.NavHostController
import com.surfsocial.feature.splash.ui.actions.SplashActions

class NavActions(
    override val controller: NavHostController,
) : SplashActions {

    val navigateToUp: () -> Unit = {
        controller.navigateUp()
    }
}