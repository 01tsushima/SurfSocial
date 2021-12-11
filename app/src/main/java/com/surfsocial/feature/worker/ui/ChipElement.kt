package com.surfsocial.feature.worker.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.surfsocial.ui.theme.ChateauGreen
import com.surfsocial.ui.theme.Waterloo

@Composable
fun ChipElement(text: String,isFirst:Boolean) {
    Card(
        elevation = 0.dp,
        shape = RoundedCornerShape(12.dp),
        backgroundColor = if(isFirst)ChateauGreen.copy(alpha = 0.12F) else Waterloo.copy(alpha = 0.12F)
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.caption,
            color = if(isFirst)ChateauGreen else Waterloo,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 2.dp)
        )
    }
}