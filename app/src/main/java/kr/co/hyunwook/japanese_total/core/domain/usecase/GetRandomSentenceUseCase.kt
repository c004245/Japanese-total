package kr.co.hyunwook.japanese_total.core.domain.usecase

import kr.co.hyunwook.japanese_total.core.data.repository.sentence.SentenceRepository
import kr.co.hyunwook.japanese_total.core.database.entity.Sentence
import javax.inject.Inject

/**
 * 랜덤으로 단어를 가져오고, 업데이트 하는 UseCase
 */
class GetRandomSentenceUseCase @Inject constructor(
    private val sentenceRepository: SentenceRepository
) {

    suspend operator fun invoke(): List<Sentence> {
        val sentences = sentenceRepository.getUnCheckedRandomSentences()
        sentences.let {
            val ids = it.map { sentence -> sentence.id }
            sentenceRepository.updateCheckSentences(ids)
        }
        return sentences
    }
}
