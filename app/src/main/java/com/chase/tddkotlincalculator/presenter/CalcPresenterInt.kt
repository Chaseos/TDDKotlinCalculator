package com.chase.tddkotlincalculator.presenter

interface CalcPresenterInt {
    fun getCalculation(bottomText: String, topText: String)
    fun continueCalculation(bottomText: String, topText: String, operator: String)
    fun checkAndAppendBottom(num: String, bottomText: String, topText: String)
    fun checkAndAppendTop(operator: String, bottomText: String, topText: String)
    fun checkAndClearDisplays()
}
