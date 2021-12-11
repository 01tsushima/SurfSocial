package com.surfsocial.feature.projects.data

import com.movacar.data.remote.model.dto.PaginationMemberDTO
import com.surfsocial.common.responses.ProjectResponse
import com.surfsocial.common.responses.TeamResponse
import com.surfsocial.feature.worker.data.RemoteDataSource
import javax.inject.Inject

class ProjectsRemoteDataSource @Inject constructor() {

    suspend fun mockProjects() = PaginationMemberDTO<ProjectResponse>(
        listOf(
            ProjectResponse(
                descriptions = "some top project",
                name = "Название проекта",
                team = TeamResponse(
                    employees = RemoteDataSource().mockWorkers()
                )
            ),
            ProjectResponse(
                descriptions = "some top project",
                name = "Название проекта",
                team = TeamResponse(
                    employees = RemoteDataSource().mockWorkers()
                )
            ),
            ProjectResponse(
                descriptions = "some top project",
                name = "Название проекта",
                team = TeamResponse(
                    employees = RemoteDataSource().mockWorkers()
                )
            ),
            ProjectResponse(
                descriptions = "some top project",
                name = "Название проекта",
                team = TeamResponse(
                    employees = RemoteDataSource().mockWorkers()
                )
            ),
            ProjectResponse(
                descriptions = "some top project",
                name = "Название проекта",
                team = TeamResponse(
                    employees = RemoteDataSource().mockWorkers()
                )
            ),
            ProjectResponse(
                descriptions = "some top project",
                name = "Название проекта",
                team = TeamResponse(
                    employees = RemoteDataSource().mockWorkers()
                )
            ),
            ProjectResponse(
                descriptions = "some top project",
                name = "Название проекта",
                team = TeamResponse(
                    employees = RemoteDataSource().mockWorkers()
                )
            )
        )
    )
}