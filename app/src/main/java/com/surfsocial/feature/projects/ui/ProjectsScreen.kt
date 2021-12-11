package com.surfsocial.feature.projects.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items

@Composable
fun ProjectsScreen(
    viewModel: ProjectsViewModel
) {
    val projects = viewModel.projectsFlow.collectAsLazyPagingItems()
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(projects) { project ->
            if (project != null) {
                ProjectElement(project = project) {
                    
                }
            }
        }
    }
}