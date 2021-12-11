package com.surfsocial.feature.worker.data

import com.movacar.data.remote.model.dto.PaginationMemberDTO
import com.surfsocial.base.pager.BasePagingSource
import com.surfsocial.common.responses.EmployeeResponse

class WorkersPagingSource(fetchMembers: (suspend (Int, Int) -> PaginationMemberDTO<EmployeeResponse>)) :
    BasePagingSource<EmployeeResponse>(fetchMembers)