package xyz.myeoru.androidstudy.paging.domain

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface LoremPicsumRepository {
    fun fetchImageList(): Flow<PagingData<ImageModel>>
}