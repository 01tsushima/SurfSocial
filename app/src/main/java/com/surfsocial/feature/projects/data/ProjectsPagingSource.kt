package com.surfsocial.feature.projects.data

import com.movacar.data.remote.model.dto.PaginationMemberDTO
import com.surfsocial.base.pager.BasePagingSource
import com.surfsocial.common.responses.ProjectResponse

class ProjectsPagingSource(fetchProjects: (suspend (Int, Int) -> PaginationMemberDTO<ProjectResponse>)) :
    BasePagingSource<ProjectResponse>(fetchProjects)