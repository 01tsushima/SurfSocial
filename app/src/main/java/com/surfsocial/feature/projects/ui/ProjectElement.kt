package com.surfsocial.feature.projects.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.surfsocial.R
import com.surfsocial.common.responses.ProjectResponse
import com.surfsocial.ui.theme.CarrotOrange
import com.surfsocial.ui.theme.fonts

@Composable
fun ProjectElement(project: ProjectResponse, onClick: () -> Unit) {
    Card(
        elevation = 20.dp, shape = RoundedCornerShape(12.dp), modifier = Modifier
            .padding(horizontal = 20.dp)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Column {
                Box(
                    Modifier
                        .background(
                            color = CarrotOrange, shape = RoundedCornerShape(
                                topEnd = 16.dp, bottomEnd =
                                16.dp, bottomStart = 16.dp
                            )
                        )
                        .width(50.dp)
                        .height(50.dp)
                ) {
                    Text(
                        text = project.name.first().uppercaseChar().toString(), style = TextStyle(
                            color = Color.White,
                            fontSize = 28.sp,
                            fontWeight = FontWeight.W700,
                            fontFamily = fonts
                        ),
                        modifier = Modifier
                            .align(alignment = Alignment.Center)

                    )
                }
                Text(
                    text = stringResource(id = R.string.team, project.team.employees.size), modifier = Modifier
                        .padding(top = 18.dp),
                    style = TextStyle(
                        MaterialTheme.colors.primary, fontFamily = fonts, fontWeight = FontWeight
                            .Normal, fontSize = 13.sp
                    )
                )
                Text(
                    text = project.name, modifier = Modifier
                        .padding(top = 6.dp),
                    style = MaterialTheme.typography.h4.copy(fontSize = 18.sp),
                    color = MaterialTheme.colors.primary
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
            ) {
                (project.team.employees.subList(0, 3)).forEachIndexed { index, image ->
                    Image(
                        painter = rememberImagePainter(data = image.photoUrl),
                        contentDescription = null,
                        modifier = Modifier
                            .offset(x = (index * -20).dp)
                            .clip(CircleShape)
                            .size(40.dp)
                    )
                }
            }

        }
    }
}