package com.chase.tddkotlincalculator.presenter

interface CalcView {

    fun appendNumberToBottomDisplay(num: String)
    fun appendCalculationToTopDisplay(operator: String)
    fun showCalculatedResult(result: String)
    fun clearDisplays()
}