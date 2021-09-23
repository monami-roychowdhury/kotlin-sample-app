package com.example.kooappassignment.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kooappassignment.api.GoRestApi
import retrofit2.HttpException

private const val STARTING_PAGE_INDEX = 1

class GoRestPagingSource(
    private val goRestApi: GoRestApi
) : PagingSource<Int, Data>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        val position = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = goRestApi.getPosts(position)
            val posts = response.data
            LoadResult.Page(
                data = posts,
                prevKey = if (position == STARTING_PAGE_INDEX) null else position - 1,
                nextKey = if (posts.isEmpty()) null else position + 1
            )
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        TODO("Not yet implemented")
    }


}