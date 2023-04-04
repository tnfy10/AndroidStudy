package xyz.myeoru.androidstudy.paging.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import xyz.myeoru.androidstudy.paging.domain.ImageModel
import xyz.myeoru.androidstudy.paging.domain.LoremPicsumRepository
import javax.inject.Inject

class LoremPicsumRepositoryImpl @Inject constructor(private val loremPicsumDataSource: LoremPicsumDataSource) :
    LoremPicsumRepository {
    override fun fetchImageList(): Flow<PagingData<ImageModel>> {
        return Pager(
            config = PagingConfig(pageSize = 20, enablePlaceholders = false),
            pagingSourceFactory = { loremPicsumDataSource }
        ).flow
    }
}