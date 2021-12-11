package com.movacar.data.remote.model.dto

import com.google.gson.annotations.SerializedName

data class PaginationMemberDTO<T>(
    @SerializedName("result")
    val items: List<T> = listOf(),
    @SerializedName("total")
    val total: Int = 0
)