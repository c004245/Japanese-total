package kr.co.hyunwook.japanese_total.util

import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kr.co.hyunwook.japanese_total.core.domain.usecase.GetRandomSentenceUseCase
import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

@HiltWorker
class SentenceNotificationWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted workerParams: WorkerParameters,
//    private val getRandomSentenceUseCase: GetRandomSentenceUseCase
) : CoroutineWorker(context, workerParams) {
    override suspend fun doWork(): Result {
        return try {
//            val sentence = getRandomSentenceUseCase()
            val notificationHelper = NotificationHelper(applicationContext)
            notificationHelper.sendNotification("ㅁㄴㅇㄹㅁㄴㅇㄹ")
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}

