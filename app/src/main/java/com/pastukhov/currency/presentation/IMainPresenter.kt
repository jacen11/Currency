package com.pastukhov.currency.presentation

interface IMainPresenter {

    fun attachView(view: IMainView)
    fun detachView()
    fun showRate(from: String, to: String,amount: String)
}