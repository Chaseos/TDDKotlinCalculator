package com.chase.tddkotlincalculator.presenter

interface CalcPresenterInt {
    fun getCalculation(bottomText: String, topText: String)
    fun checkToAppendBottom(num: String, bottomText: String, topText: String)
    fun checkToAppendTop(operator: String, bottomText: String, topText: String)
}
