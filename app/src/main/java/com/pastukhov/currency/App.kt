package com.pastukhov.currency

import android.app.Application
import com.pastukhov.currency.di.AppComponent
import com.pastukhov.currency.di.DaggerAppComponent

class App : Application() {

    companion object {
         var appComponent: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    private fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
            .build()
    }
}