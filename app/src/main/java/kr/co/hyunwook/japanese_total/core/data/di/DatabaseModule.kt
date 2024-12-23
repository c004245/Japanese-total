package kr.co.hyunwook.japanese_total.core.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kr.co.hyunwook.japanese_total.core.database.AppDatabase
import kr.co.hyunwook.japanese_total.core.database.SentenceDao
import android.app.Application
import android.content.Context
import javax.inject.Named
import javax.inject.Singleton
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.Room

@Module
@InstallIn(SingletonComponent::class)
internal object DatabaseModule {


    private const val SENTENCE_DATASTORE_NAME = "SENTENCE_PREFERENCES"

    private val Context.sentenceDataSource by preferencesDataStore(SENTENCE_DATASTORE_NAME)


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
    @Named("sentence")
    fun provideSentenceDataStore(
        @ApplicationContext context: Context
    ): DataStore<Preferences> =
        context.sentenceDataSource

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

