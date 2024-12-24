package kr.co.hyunwook.japanese_total.core.domain.usecase

import kotlinx.coroutines.flow.Flow
import kr.co.hyunwook.japanese_total.core.data.repository.sentence.SentenceRepository
import kr.co.hyunwook.japanese_total.feature.main.onboarding.LevelType
import javax.inject.Inject

class GetLevelUseCase @Inject constructor(
    private val sentenceRepository: SentenceRepository
) {
    suspend operator fun invoke(): Flow<LevelType> =
        sentenceRepository.getLevel()

}
