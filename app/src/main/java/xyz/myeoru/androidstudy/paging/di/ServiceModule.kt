package xyz.myeoru.androidstudy.paging.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.myeoru.androidstudy.paging.data.LoremPicsumService
import xyz.myeoru.androidstudy.utils.ApiHelper
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Singleton
    @Provides
    fun provideLoremPicsumService() =
        ApiHelper.create(LoremPicsumService::class.java, "https://picsum.photos")
}