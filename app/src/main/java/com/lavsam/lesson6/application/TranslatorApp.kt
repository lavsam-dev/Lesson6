package com.lavsam.lesson6.application

import android.app.Application
import com.lavsam.lesson6.di.application
import com.lavsam.lesson6.di.historyScreen
import com.lavsam.lesson6.di.mainScreen
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext.startKoin

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    application, mainScreen, historyScreen
                )
            )
        }
    }
}