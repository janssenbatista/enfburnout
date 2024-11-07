package dev.janssenbatista.enfburnout

import android.app.Application
import dev.janssenbatista.enfburnout.di.appModule
import dev.janssenbatista.enfburnout.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(listOf(appModule, networkModule))
        }
    }
}