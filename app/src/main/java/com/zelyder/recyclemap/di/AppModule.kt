package com.zelyder.recyclemap.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.zelyder.recyclemap.data.data_source.LearnDao
import com.zelyder.recyclemap.data.data_source.LearnDatabase
import com.zelyder.recyclemap.data.repository.LearnRepositoryImpl
import com.zelyder.recyclemap.domain.repository.LearnRepository
import com.zelyder.recyclemap.domain.use_case.DeleteLearnItemUseCase
import com.zelyder.recyclemap.domain.use_case.GetLearnListUseCase
import com.zelyder.recyclemap.domain.use_case.LearnUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLearnDatabase(app: Application): LearnDatabase {
        return Room.databaseBuilder(
            app,
            LearnDatabase::class.java,
            LearnDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideLearnRepository(db: LearnDatabase): LearnRepository {
        return LearnRepositoryImpl(db.learnDao)
    }

    @Provides
    @Singleton
    fun provideLearnUseCases(repository: LearnRepository): LearnUseCases {
        return LearnUseCases(
            getLearnList = GetLearnListUseCase(repository),
            deleteLearnItem = DeleteLearnItemUseCase(repository)
        )
    }
}