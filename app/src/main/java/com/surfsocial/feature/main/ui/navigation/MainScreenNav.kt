package com.surfsocial.feature.main.ui.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.surfsocial.base.navigation.NavActions
import com.surfsocial.feature.main.ui.MainScreen
import com.surfsocial.feature.main.ui.route.MainScreenRoute

@ExperimentalPagerApi
fun NavGraphBuilder.mainScreenNav(
    navAction: NavActions
) {
    composable(MainScreenRoute.value) {
        MainScreen(viewModel = hiltViewModel()) {

        }
    }
}