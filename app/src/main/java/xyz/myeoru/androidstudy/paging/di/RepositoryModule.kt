package xyz.myeoru.androidstudy.paging.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.myeoru.androidstudy.paging.data.LoremPicsumRepositoryImpl
import xyz.myeoru.androidstudy.paging.domain.LoremPicsumRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindLoremPicsumRepository(loremPicsumRepositoryImpl: LoremPicsumRepositoryImpl): LoremPicsumRepository
}