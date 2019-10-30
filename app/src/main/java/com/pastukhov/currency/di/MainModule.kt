package com.pastukhov.chucknorris.di


import dagger.Binds
import dagger.Module

@Module
interface MainModule {

    @Binds
    fun providePresenter(impl: MainPresenter): IMainPresenter
}