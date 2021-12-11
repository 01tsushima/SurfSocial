package com.surfsocial.base.pager

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.movacar.data.remote.model.dto.PaginationMemberDTO
import retrofit2.HttpException
import java.io.IOException

abstract class BasePagingSource<VALUE : Any>(private val fetchData: (suspend (Int, Int) -> PaginationMemberDTO<VALUE>)) : PagingSource<Int, VALUE>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, VALUE> = try {
        val page = if (params.key == null || params.key == 0) 1 else params.key ?: 1
        val data = fetchData(page, params.loadSize)
        val nextPage = if (data.total <= params.loadSize * page) null else page + 1

        LoadResult.Page(data.items, null, nextPage)
    } catch (exception: IOException) {
        LoadResult.Error(exception)
    } catch (exception: HttpException) {
        LoadResult.Error(exception)
    }

    override fun getRefreshKey(state: PagingState<Int, VALUE>) = state.anchorPosition

}