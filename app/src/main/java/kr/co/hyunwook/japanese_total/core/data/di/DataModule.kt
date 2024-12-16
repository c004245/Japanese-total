package kr.co.hyunwook.japanese_total.core.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.co.hyunwook.japanese_total.core.data.repository.sentence.SentenceRepository
import kr.co.hyunwook.japanese_total.core.data.repository.sentence.SentenceRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
internal interface DataModule {
    @Binds
    fun bindsSentenceRepository(sentenceRepositoryImpl: SentenceRepositoryImpl): SentenceRepository
}
