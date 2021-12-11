package com.surfsocial.feature.worker.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.google.accompanist.flowlayout.FlowRow
import com.surfsocial.common.responses.EmployeeResponse

@Composable
fun WorkerElement(worker: EmployeeResponse, onClick: () -> Unit) {
    Card(
        elevation = 20.dp, shape = RoundedCornerShape(12.dp), modifier = Modifier
            .padding(horizontal = 20.dp)
            .height
                (140.dp)
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Text(
                text = worker.userInfo.name,
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.primary,
                modifier = Modifier
                    .fillMaxWidth()
            )
            Row {
                Image(
                    painter = rememberImagePainter(data = worker.photoUrl),
                    contentDescription = null,
                    modifier = Modifier
                        .align(alignment = Alignment.CenterVertically)
                        .width(40.dp)
                        .height(40.dp)
                        .size(40.dp)
                        .clip(CircleShape)
                )
                Column(modifier = Modifier.padding(start = 16.dp)) {
                    Text(
                        text = worker.position,
                        style = MaterialTheme.typography.h3,
                        color = MaterialTheme.colors.primary,
                    )
                    FlowRow(
                        Modifier.padding(top = 8.dp),
                        mainAxisSpacing = 4.dp, crossAxisSpacing = 4.dp
                    ) {
                        worker.skills.forEachIndexed {index,value->
                            ChipElement(text = value,index==0)
                        }
                    }
                }
            }
        }
    }
}