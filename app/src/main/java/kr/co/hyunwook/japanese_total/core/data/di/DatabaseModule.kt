package kr.co.hyunwook.japanese_total.core.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.hyunwook.japanese_total.core.database.AppDatabase
import kr.co.hyunwook.japanese_total.core.database.SentenceDao
import android.app.Application
import android.content.Context
import javax.inject.Singleton
import androidx.room.Room

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application
    ): AppDatabase {
        return Room.databaseBuilder(application, AppDatabase::class.java, "sentence.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideSentenceDao(appDatabase: AppDatabase): SentenceDao {
        return appDatabase.sentenceDao()
    }


    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }
}

