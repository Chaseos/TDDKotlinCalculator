package com.chase.tddkotlincalculator

interface CalcView {

    fun putNumberInBottomDisplay(num: String)
    fun putEquationInTopDisplay(operator: String)
    fun showCalculatedResult(result: String)
    fun clearDisplays()
}