package kr.co.hyunwook.japanese_total

import dagger.hilt.android.HiltAndroidApp
import kr.co.hyunwook.japanese_total.util.scheduleDailyNotification
import android.app.Application
import javax.inject.Inject
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration

@HiltAndroidApp
class App: Application(), Configuration.Provider {


    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .build()
    }
}

