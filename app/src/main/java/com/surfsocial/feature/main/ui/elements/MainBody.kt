package com.surfsocial.feature.main.ui.elements

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.surfsocial.R
import com.surfsocial.feature.projects.ui.ProjectsScreen
import com.surfsocial.feature.worker.ui.WorkerScreen
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun MainBody(onSearchClick: () -> Unit) {

    val tabs = listOf(TabItem.Workers, TabItem.Projects, TabItem.About)
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(pageCount = tabs.size)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 14.dp, start = 20.dp, end = 20.dp)
        ) {
            Image(
                modifier = Modifier.align(Alignment.TopStart),
                painter = painterResource(
                    id = if (isSystemInDarkTheme()) R.drawable.ic_logo_light
                    else R.drawable.ic_logo_dark
                ),
                contentDescription = null,
            )
            searchButton(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .width(45.dp)
                    .height(45.dp)
            ) {

            }
        }
        ScrollableTabRow(
            divider = {},
            edgePadding = TabRowDefaults.DividerThickness,
            backgroundColor = MaterialTheme.colors.background,
            modifier = Modifier.padding(top = 24.dp),
            selectedTabIndex = pagerState.currentPage,
            indicator = @Composable { tabPositions ->
                TabRowDefaults.Indicator(
                    color = MaterialTheme.colors.primaryVariant,
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[pagerState.currentPage])
                        .padding(horizontal = 55.dp)
                )
            }) {
            tabs.forEachIndexed { index, tabItem ->
                val interactionSource = remember { MutableInteractionSource() }
                Tab(
                    selected = pagerState.currentPage == index,
                    selectedContentColor = MaterialTheme.colors.primaryVariant,
                    unselectedContentColor = MaterialTheme.colors.secondary,
                    onClick = {
                        scope.launch {
                            pagerState.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(
                            text = stringResource(id = tabs[index].title),
                            style = MaterialTheme.typography.h2
                        )
                    },
                    interactionSource = interactionSource
                )

            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
        ) {
            if (currentPage == 0) WorkerScreen(viewModel = hiltViewModel())
            else if (currentPage==1) ProjectsScreen(viewModel = hiltViewModel())
            else Text(text = "hello $currentPage", modifier = Modifier.fillMaxSize())
        }
    }
}