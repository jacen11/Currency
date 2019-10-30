package com.pastukhov.currency.di

import com.pastukhov.chucknorris.di.MainModule
import com.pastukhov.chucknorris.di.RestModule
import com.pastukhov.currency.MainActivity
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