package kr.co.hyunwook.japanese_total.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.hyunwook.japanese_total.core.datastore.datasource.DefaultSentencePreferencesDataSource
import kr.co.hyunwook.japanese_total.core.datastore.datasource.SentencePreferencesDataSource

@InstallIn(SingletonComponent::class)
@Module
internal abstract class DataStoreModule {

    @Binds
    abstract fun bindSentenceLocalDataSource(
        dataSource: DefaultSentencePreferencesDataSource
    ): SentencePreferencesDataSource
}