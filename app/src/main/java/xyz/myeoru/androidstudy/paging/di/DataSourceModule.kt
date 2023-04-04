package xyz.myeoru.androidstudy.paging.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.myeoru.androidstudy.paging.data.LoremPicsumDataSource
import xyz.myeoru.androidstudy.paging.data.LoremPicsumService

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {

    @Provides
    fun provideLoremPicsumDataSource(loremPicsumService: LoremPicsumService) =
        LoremPicsumDataSource(loremPicsumService)
}