package com.surfsocial.feature.worker.ui

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
fun WorkerScreen(viewModel: WorkerViewModel) {
    val workers = viewModel.workersFlow.collectAsLazyPagingItems()
    LazyColumn(
        Modifier
            .fillMaxSize()
            .padding(top = 16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(workers) { worker ->
            if (worker != null) {
                WorkerElement(worker = worker) {
                    //todo redirect to detail
                }
            }
        }
    }
}