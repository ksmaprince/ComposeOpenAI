package com.khun.composeopenai.di

import android.content.Context
import androidx.room.Room
import com.khun.composeopenai.data.local.AnswerDao
import com.khun.composeopenai.data.local.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DBModule {

    @Provides
    @Singleton
    fun provideDao(db: AppDatabase): AnswerDao{
        return db.answerDao()
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase{
        return Room.databaseBuilder(
            context = context,
            klass = AppDatabase::class.java,
            "app_db"
        ).build()
    }

}