package com.example.kooappassignment.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.kooappassignment.api.GoRestApi
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GoRestRepository @Inject constructor(private val goRestApi: GoRestApi) {

    fun getPosts() =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { GoRestPagingSource(goRestApi) }
        ).liveData
}