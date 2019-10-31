package com.pastukhov.currency.di

import com.pastukhov.currency.presentation.IMainPresenter
import com.pastukhov.currency.presentation.MainPresenter
import dagger.Binds
import dagger.Module


@Module
interface MainModule {

    @Binds
    fun providePresenter(impl: MainPresenter): IMainPresenter
}