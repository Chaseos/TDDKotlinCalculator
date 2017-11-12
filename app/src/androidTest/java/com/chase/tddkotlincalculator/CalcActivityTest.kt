package com.chase.tddkotlincalculator

import android.content.Intent
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.*
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalcActivityTest {
    private val activityTestRule = ActivityTestRule<CalcActivity>(CalcActivity::class.java)

    @Test
    fun checkNumbersAreDisplayed() {
        activityTestRule.launchActivity(Intent())
        onView(withId(R.id.btn_1)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.btn_2)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.btn_3)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.btn_4)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.btn_5)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.btn_6)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.btn_7)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.btn_8)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.btn_9)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.btn_0)).check(matches(isDisplayed())).perform(click())
        onView(withText("1234567890")).check(matches(isDisplayed()))
    }

    @Test
    fun checkOperationAddsToTop() {
        activityTestRule.launchActivity(Intent())
        onView(withId(R.id.btn_1)).check(matches(isDisplayed())).perform(click())
        onView(withId(R.id.btn_add)).check(matches(isDisplayed())).perform(click())
        onView(withText("1 +")).check(matches(isDisplayed()))
    }
}