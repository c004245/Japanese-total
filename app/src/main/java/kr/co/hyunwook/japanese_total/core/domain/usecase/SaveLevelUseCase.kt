package kr.co.hyunwook.japanese_total.core.domain.usecase

import kr.co.hyunwook.japanese_total.core.data.repository.sentence.SentenceRepository
import kr.co.hyunwook.japanese_total.feature.main.onboarding.LevelType
import javax.inject.Inject

/**
 * 난이도를 저장하는 usecase
 */
class SaveLevelUseCase @Inject constructor(
    private val sentenceRepository: SentenceRepository
) {
    suspend operator fun invoke(levelType: LevelType) = sentenceRepository.saveLevel(levelType)
}
