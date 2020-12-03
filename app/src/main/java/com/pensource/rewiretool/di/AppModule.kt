package com.pensource.rewiretool.di

import android.content.Context
import com.pensource.rewiretool.data.db.AppDatabase
import com.pensource.rewiretool.data.db.ReasonDao
import com.pensource.rewiretool.data.reason.DefaultReasonRepository
import com.pensource.rewiretool.data.reason.LocalReasonDataSource
import com.pensource.rewiretool.data.reason.ReasonDataSource
import com.pensource.rewiretool.data.reason.ReasonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object AppModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.buildDatabase(context)
    }

    @Singleton
    @Provides
    fun provideReasonDao(appDatabase: AppDatabase): ReasonDao {
        return appDatabase.reasonDao()
    }

    @Singleton
    @Provides
    fun provideDispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @Singleton
    @Provides
    fun provideReasonRepository(reasonDataSource: ReasonDataSource): ReasonRepository {
        return DefaultReasonRepository(reasonDataSource)
    }

    @Singleton
    @Provides
    fun provideReasonDataSource(reasonDao: ReasonDao): ReasonDataSource {
        return LocalReasonDataSource(reasonDao)
    }
}