package com.pastukhov.currency.di

import com.pastukhov.currency.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        RestModule::class,
        MainModule::class
    ]
)
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}