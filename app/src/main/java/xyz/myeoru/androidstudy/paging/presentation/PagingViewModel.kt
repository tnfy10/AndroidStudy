package xyz.myeoru.androidstudy.paging.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import xyz.myeoru.androidstudy.paging.domain.ImageModel
import xyz.myeoru.androidstudy.paging.domain.LoremPicsumRepository
import javax.inject.Inject

@HiltViewModel
class PagingViewModel @Inject constructor(private val loremPicsumRepository: LoremPicsumRepository) :
    ViewModel() {
    private val _uiState = MutableStateFlow<PagingState>(PagingState.Init)
    val uiState: StateFlow<PagingState> = _uiState

    init {
        viewModelScope.launch {
            fetchImageList().catch {
                _uiState.value = PagingState.Init
            }.collect {
                _uiState.value = PagingState.Loaded(it)
            }
        }
    }

    private fun fetchImageList(): Flow<PagingData<ImageModel>> {
        return loremPicsumRepository.fetchImageList()
    }
}

sealed class PagingState {
    object Init : PagingState()
    data class Loaded(val imagePagingData: PagingData<ImageModel>) : PagingState()
}