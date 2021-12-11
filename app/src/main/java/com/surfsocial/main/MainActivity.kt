package com.surfsocial.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.pager.ExperimentalPagerApi
import com.surfsocial.ui.theme.SurfSocialTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    @ExperimentalPagerApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { activityContent() }
    }

    @ExperimentalPagerApi
    @Composable
    fun activityContent() {
        navController = rememberNavController()
        ProvideWindowInsets {
            SurfSocialTheme {
                NavGraph(navController = navController)
            }
        }
    }
}

