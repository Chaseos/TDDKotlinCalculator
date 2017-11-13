package com.chase.tddkotlincalculator

import com.chase.tddkotlincalculator.model.CalcModel
import org.junit.Assert
import org.junit.Test

private const val VALUE_A = 2.0
private const val VALUE_B = 3.0

class CalcModelTest {

    private val calcModel = CalcModel()

    @Test
    fun addTwoNumbers() {
        Assert.assertEquals(5.0, calcModel.calculate(VALUE_A, VALUE_B, "+"), .01)
    }

    @Test
    fun subtractTwoNumbers() {
        Assert.assertEquals(-1.0, calcModel.calculate(VALUE_A, VALUE_B, "-"), 0.01)
        Assert.assertEquals(1.0, calcModel.calculate(VALUE_B, VALUE_A, "-"), 0.01)
    }

    @Test
    fun multiplyTwoNumbers() {
        Assert.assertEquals(6.0, calcModel.calculate(VALUE_A, VALUE_B, "*"), 0.01)
    }

    @Test
    fun divideTwoNumbers() {
        Assert.assertEquals(0.66, calcModel.calculate(VALUE_A, VALUE_B, "/"), 0.01)
        Assert.assertEquals(1.5, calcModel.calculate(VALUE_B, VALUE_A, "/"), 0.01)
    }
}