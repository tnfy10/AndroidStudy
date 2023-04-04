package xyz.myeoru.androidstudy.paging.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import xyz.myeoru.androidstudy.paging.domain.ImageModel
import javax.inject.Inject

class LoremPicsumDataSource @Inject constructor(private val service: LoremPicsumService) : PagingSource<Int, ImageModel>() {
    override fun getRefreshKey(state: PagingState<Int, ImageModel>): Int {
        return 0
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ImageModel> {
        val page = params.key ?: 0
        val resp = service.getImageList(page)

        if (resp.isSuccessful) {
            val data = resp.body() ?: throw Throwable("data is null")
            val nextPage = if (data.size == 20) page + 1 else null
            return LoadResult.Page(data = data, nextKey = nextPage, prevKey = null)
        } else {
            throw Throwable("error body: ${resp.errorBody()?.string()}")
        }
    }
}