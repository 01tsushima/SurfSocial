package com.surfsocial.feature.projects.data

import javax.inject.Inject

class ProjectsRepository @Inject constructor(private val rds: ProjectsRemoteDataSource) {

    suspend fun getProjects(page:Int,pageSize:Int) = rds.mockProjects()
}