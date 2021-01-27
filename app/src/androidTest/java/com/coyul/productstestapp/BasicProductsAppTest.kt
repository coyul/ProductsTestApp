package com.coyul.productstestapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.coyul.productstestapp.presentation.activity.MainActivity
import com.coyul.productstestapp.presentation.adapter.ProductViewHolder
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BasicProductsAppTest {

    @get:Rule
    val rule: ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    private lateinit var app: App

    @Before
    fun setup() {
        rule.scenario
    }

    @Test
    fun onCreate() {
        onView(withId(R.id.container)).check(matches(isDisplayed()))
        onView(withId(R.id.categories_products_recycler_view)).check(matches(isDisplayed()))
    }

    @Test
    fun onProductSelected() {
        onView(withId(R.id.categories_products_recycler_view))
            .perform(actionOnItemAtPosition<ProductViewHolder>(1, click()))
        onView(withId(R.id.product_name)).check(matches(isDisplayed()))
        onView(withId(R.id.product_image)).check(matches(isDisplayed()))
        onView(withId(R.id.amount)).check(matches(isDisplayed()))
        onView(withId(R.id.currency)).check(matches(isDisplayed()))
    }
}