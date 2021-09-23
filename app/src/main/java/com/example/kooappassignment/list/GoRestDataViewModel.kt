package com.example.kooappassignment.list

import androidx.lifecycle.*
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.map
import com.example.kooappassignment.data.Data
import com.example.kooappassignment.data.GoRestRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GoRestDataViewModel @Inject constructor(
    private val repository: GoRestRepository,
    private val state: SavedStateHandle
) : ViewModel() {

    private val currentPage = state.getLiveData(CURRENT_PAGE, DEFAULT_PAGE)
    val posts = currentPage.switchMap {
        repository.getPosts()
            .cachedIn(viewModelScope)

    }

    companion object {
        private const val CURRENT_PAGE = "CURRENT_PAGE"
        private const val DEFAULT_PAGE = 1
    }


}
