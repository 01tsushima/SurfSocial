package com.surfsocial.feature.worker.data

import javax.inject.Inject

class WorkerRepository @Inject constructor(private val rds:RemoteDataSource) {
    suspend fun returnWorkers(page:Int,pageSize:Int) = rds.getData(page,pageSize)
}