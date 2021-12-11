package com.surfsocial.feature.main.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.surfsocial.R
import com.surfsocial.ui.theme.*

@Composable
fun searchButton(
    modifier: Modifier,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    Button(
        onClick = onClick,
        interactionSource = interactionSource,
        colors = ButtonDefaults.textButtonColors(
            backgroundColor = when {
                isSystemInDarkTheme() && !isPressed -> Shark
                isSystemInDarkTheme() && isPressed -> White
                !isSystemInDarkTheme() && !isPressed -> White
                else -> Shark
            }
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = modifier,
        elevation = ButtonDefaults.elevation(defaultElevation = 0.dp, pressedElevation = 0.dp),
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .padding(0.dp, 0.dp),
            painter = painterResource(id = R.drawable.ic_search),
            colorFilter = ColorFilter.tint(
                when {
                    isSystemInDarkTheme() && !isPressed -> White
                    isSystemInDarkTheme() && isPressed -> DodgerBlue
                    !isSystemInDarkTheme() && !isPressed -> Martinique
                    else -> AzureRadiance
                },
                BlendMode.SrcAtop
            ),
            contentDescription = null,
            contentScale = ContentScale.Fit
        )
    }
}