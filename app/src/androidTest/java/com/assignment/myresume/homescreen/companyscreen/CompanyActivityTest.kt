package com.assignment.myresume.homescreen.companyscreen

import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.assignment.myresume.R
import com.assignment.myresume.utils.Constants
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class CompanyActivityTest {

    val intentCompanyUrl = "b03778260d79c4f0d9c31776a3b7d3f8/raw/b802f11336617452c9905408f130adc7ab2ade85/globant"
    val intentCompanyName = "Globant"
    @get:Rule
    var rule = ActivityTestRule(CompanyActivity::class.java)

    private fun launchCompanyActivity() {
        val intent = Intent()
        intent.putExtra(Constants.IntentKeys.COMPANY_DETAIL_URL, intentCompanyUrl)
        intent.putExtra(Constants.IntentKeys.COMPANY_NAME, intentCompanyName)
        rule.launchActivity(intent)
        Thread.sleep(3000)
    }

    @Test
    fun testCompanyName() {
        launchCompanyActivity()
        Espresso.onView(ViewMatchers.withId(R.id.tvName))
            .check(ViewAssertions.matches(ViewMatchers.withText("Globant")))
    }

    @Test
    fun testDuration() {
        launchCompanyActivity()
        Espresso.onView(ViewMatchers.withId(R.id.tvDuration))
            .check(ViewAssertions.matches(ViewMatchers.withText("1 year 5 months")))
    }

    @Test
    fun testStartDate() {
        launchCompanyActivity()
        Espresso.onView(ViewMatchers.withId(R.id.tvStartDate))
            .check(ViewAssertions.matches(ViewMatchers.withText("Mar 2018")))
    }

    @Test
    fun testEndDate() {
        launchCompanyActivity()
        Espresso.onView(ViewMatchers.withId(R.id.tvEndDate))
            .check(ViewAssertions.matches(ViewMatchers.withText("Working here")))
    }

    @Test
    fun testDesignation() {
        launchCompanyActivity()
        Espresso.onView(ViewMatchers.withId(R.id.tvDesignation))
            .check(ViewAssertions.matches(ViewMatchers.withText("- Sr. Software Engineer\n")))
    }
}