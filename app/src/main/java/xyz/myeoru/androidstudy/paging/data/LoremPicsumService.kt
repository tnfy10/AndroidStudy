package xyz.myeoru.androidstudy.paging.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import xyz.myeoru.androidstudy.paging.domain.ImageModel

interface LoremPicsumService {
    @GET("/v2/list")
    suspend fun getImageList(
        @Query("page") page: Int,
        @Query("limit") limit: Int = 20
    ): Response<List<ImageModel>>
}