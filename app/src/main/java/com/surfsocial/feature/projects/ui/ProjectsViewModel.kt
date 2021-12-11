package com.surfsocial.feature.projects.ui

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.surfsocial.feature.projects.data.ProjectsPagingSource
import com.surfsocial.feature.projects.data.ProjectsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProjectsViewModel @Inject constructor(private val repository: ProjectsRepository) : ViewModel() {

    val projectsFlow by lazy {
        Pager(PagingConfig(PAGE_SIZE, initialLoadSize = PAGE_SIZE)) {
            ProjectsPagingSource { page, pageSize ->
                repository.getProjects(page, pageSize)
            }
        }.flow
    }

    companion object {
        private const val PAGE_SIZE = 25
    }
}