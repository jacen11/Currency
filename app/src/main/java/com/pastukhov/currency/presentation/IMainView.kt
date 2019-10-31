package com.pastukhov.currency.presentation

interface IMainView {

    fun getSpnTo(): String
    fun getSpnFrom(): String
    fun getNumber(): String
    fun setTxtResult(txt:String)
}