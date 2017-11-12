package com.chase.tddkotlincalculator.model

class CalcModel {
    fun calculate(numOne: Double, numTwo: Double, method: String): Double {
        return when(method) {
            "+" -> numOne + numTwo
            "-" -> numOne - numTwo
            "*" -> numOne * numTwo
            "/" -> numOne / numTwo
            else -> 0.0
        }
    }
}