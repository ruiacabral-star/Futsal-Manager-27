package com.futsalmanager.di

import android.content.Context
import com.futsalmanager.data.local.AppDatabase
import com.futsalmanager.data.local.dao.ClubDao
import com.futsalmanager.data.local.dao.PlayerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase {
        return AppDatabase.getInstance(context)
    }

    @Provides fun provideClubDao(db: AppDatabase): ClubDao = db.clubDao()
    @Provides fun providePlayerDao(db: AppDatabase): PlayerDao = db.playerDao()
}
