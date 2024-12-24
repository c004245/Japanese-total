package kr.co.hyunwook.japanese_total.util

import android.content.Context
import android.util.Log
import java.util.Calendar
import java.util.concurrent.TimeUnit
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

fun scheduleDailyNotification(context: Context) {
    val now = Calendar.getInstance()
    val targetTime = Calendar.getInstance().apply {
        set(Calendar.HOUR_OF_DAY, 9)
        set(Calendar.MINUTE, 0)
        set(Calendar.SECOND, 0)
    }

    if (now.after(targetTime)) {
        targetTime.add(Calendar.DAY_OF_MONTH, 1)
    }

    val initialDelay = targetTime.timeInMillis - now.timeInMillis


    val workRequest = OneTimeWorkRequestBuilder<SentenceNotificationWorker>().build()
    WorkManager.getInstance(context).enqueue(workRequest)


}