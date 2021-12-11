package com.surfsocial.common.responses

data class EmployeeResponse(
    val createdDate: Int = 0,
    val currentProject: String = "",
    val department: String = "",
    val experience: String = "",
    val id: String = "",
    val photoUrl: String = "",
    val position: String = "",
    val skills: List<String> = listOf(),
    val userInfo: UserInfoResponse = UserInfoResponse()
)