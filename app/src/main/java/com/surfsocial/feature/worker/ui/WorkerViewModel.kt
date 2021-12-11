package com.surfsocial.feature.worker.ui

import androidx.lifecycle.ViewModel
import androidx.paging.*
import com.surfsocial.feature.worker.data.WorkerRepository
import com.surfsocial.feature.worker.data.WorkersPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WorkerViewModel @Inject constructor(repository: WorkerRepository):ViewModel() {
    val workersFlow by lazy {
        Pager(PagingConfig(PAGE_SIZE, initialLoadSize = PAGE_SIZE)){
            WorkersPagingSource{page,pageSize->
                repository.returnWorkers(page,pageSize)
            }
        }.flow
    }

    companion object{
        private const val PAGE_SIZE = 25
    }
}