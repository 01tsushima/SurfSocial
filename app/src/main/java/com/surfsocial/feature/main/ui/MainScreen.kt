package com.surfsocial.feature.main.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.surfsocial.feature.main.ui.elements.MainBody
import com.surfsocial.feature.main.ui.events.MainScreenEvent

@ExperimentalPagerApi
@Composable
fun MainScreen(
    viewModel: MainViewModel,
    onEvent: (MainScreenEvent) -> Unit = {}
) {
    val systemUiController = rememberSystemUiController()

    systemUiController.setStatusBarColor(MaterialTheme.colors.background)

    MainBody {}
}