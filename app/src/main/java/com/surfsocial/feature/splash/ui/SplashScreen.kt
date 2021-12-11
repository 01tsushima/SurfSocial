package com.surfsocial.feature.splash.ui

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.surfsocial.R
import com.surfsocial.feature.splash.ui.events.RedirectToMainEvent
import com.surfsocial.ui.theme.AzureRadiance
import com.surfsocial.ui.theme.Bunker
import com.surfsocial.ui.theme.DodgerBlue
import com.surfsocial.ui.theme.White
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(
    onEvent: (RedirectToMainEvent) -> Unit = {}
) {
    val scale = remember {
        Animatable(0f)
    }
    val systemUiController = rememberSystemUiController()

    val background = MaterialTheme.colors.background

    systemUiController.setStatusBarColor(color = background)
    // AnimationEffect
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.7f,
            animationSpec = tween(
                durationMillis = 800,
                easing = {
                    OvershootInterpolator(4f).getInterpolation(it)
                })
        )
        delay(1000)
        onEvent(RedirectToMainEvent)
    }
    Scaffold(backgroundColor = background) {
        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(
                    id = if (isSystemInDarkTheme()) R.drawable.ic_splash_dark
                    else R.drawable.ic_splash_light
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .align(alignment = Alignment.Center),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .align(alignment = Alignment.BottomCenter)
                    .padding(26.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_android),
                    contentDescription = null,
                    colorFilter = ColorFilter.tint(
                        if (isSystemInDarkTheme()) DodgerBlue else AzureRadiance, BlendMode.SrcAtop
                    ),
                )
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.body1.copy(
                        color = if (isSystemInDarkTheme()) White else Bunker,
                        fontSize =
                        16.sp
                    )
                )
            }
        }
    }
}