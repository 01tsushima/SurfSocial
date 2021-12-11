package com.movacar.data.remote.model.dto

import com.google.gson.annotations.SerializedName

data class PaginationDTO<T>(
    @SerializedName("data")
    val data: PaginationMemberDTO<T>,
)