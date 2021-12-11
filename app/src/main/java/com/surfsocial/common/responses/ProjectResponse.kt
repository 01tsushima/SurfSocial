package com.surfsocial.common.responses

data class ProjectResponse(
    val descriptions: String = "",
    val id: String = "",
    val name: String = "",
    val team: TeamResponse = TeamResponse()
)



