package com.zelyder.recyclemap.di

import android.app.Application
import com.zelyder.recyclemap.data.data_source.News
import com.zelyder.recyclemap.data.data_source.RiaNews
import com.zelyder.recyclemap.data.repository.FeedRepositoryImpl
import com.zelyder.recyclemap.data.repository.LearnRepositoryImpl
import com.zelyder.recyclemap.domain.repository.FeedRepository
import com.zelyder.recyclemap.domain.repository.LearnRepository
import com.zelyder.recyclemap.domain.use_case.DeleteLearnItemUseCase
import com.zelyder.recyclemap.domain.use_case.GetCodesListUseCase
import com.zelyder.recyclemap.domain.use_case.GetLearnListUseCase
import com.zelyder.recyclemap.domain.use_case.LearnUseCases
import com.zelyder.recyclemap.domain.use_case.feed.FeedUseCases
import com.zelyder.recyclemap.domain.use_case.feed.GetFeedListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

//    @Provides
//    @Singleton
//    fun provideLearnDatabase(app: Application): LearnDatabase {
//        return Room.databaseBuilder(
//            app,
//            LearnDatabase::class.java,
//            LearnDatabase.DATABASE_NAME
//        ).build()
//    }

    @Provides
    @Singleton
    fun provideNews(): News {
        return RiaNews()
    }

    @Provides
    @Singleton
    fun provideLearnRepository(app: Application): LearnRepository {
        return LearnRepositoryImpl(app)
    }

    @Provides
    @Singleton
    fun provideFeedRepository(news: News): FeedRepository {
        return FeedRepositoryImpl(news)
    }

    @Provides
    @Singleton
    fun provideLearnUseCases(repository: LearnRepository): LearnUseCases {
        return LearnUseCases(
            getLearnList = GetLearnListUseCase(repository),
            deleteLearnItem = DeleteLearnItemUseCase(repository),
            getCodesList = GetCodesListUseCase(repository)
        )
    }

    @Provides
    @Singleton
    fun provideFeedUseCases(repository: FeedRepository): FeedUseCases {
        return FeedUseCases(
            getFeedListUseCase = GetFeedListUseCase(repository)
        )
    }
}