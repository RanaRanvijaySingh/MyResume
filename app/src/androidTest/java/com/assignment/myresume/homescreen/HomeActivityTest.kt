@file:Suppress("DEPRECATION")

package com.assignment.myresume.homescreen

import android.view.ViewGroup
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.registerIdlingResources
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.assignment.myresume.R
import org.hamcrest.Matchers
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class HomeActivityTest {

    @get:Rule
    var rule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun test_UserName() {
        registerIdlingResources(rule.activity.idleResource)
        onView(withId(R.id.tvName))
            .check(matches(withText("Rana Ranvijay Singh")))
    }

    @Test
    fun testStaticContent() {
        onView(withId(R.id.tvApiToolTitle))
            .check(matches(withText("API TOOLS")))

        onView(withId(R.id.tvCompaniesTitle))
            .check(matches(withText("COMPANIES WORKED WITH")))
    }

    @Test
    fun test_ScrollToEnd() {
        registerIdlingResources(rule.activity.idleResource)
        onView(withId(R.id.tvName))
            .check(matches(withText("Rana Ranvijay Singh")))
    }

    @Test
    fun testCompaniesNames() {
        registerIdlingResources(rule.activity.idleResource)
        Espresso.onView(withId(R.id.svParent)).perform(ViewActions.swipeUp())
        Espresso.onView(withId(R.id.svParent)).perform(ViewActions.swipeUp())
        onView(
            Matchers.allOf(
                withId(R.id.tvCompany), withText("Webonise lab"),
                TestUtils.childAtPosition(
                    TestUtils.childAtPosition(
                        IsInstanceOf.instanceOf(ViewGroup::class.java), 0
                    ), 0
                ),
                ViewMatchers.isDisplayed()
            )
        ).perform(click())
        onView(withId(R.id.tvName))
            .check(matches(withText("Webonise lab")))
    }

    @Test
    fun testWeboniseLabTap() {
        registerIdlingResources(rule.activity.idleResource)
        Espresso.onView(withId(R.id.svParent)).perform(ViewActions.swipeUp())
        Espresso.onView(withId(R.id.svParent)).perform(ViewActions.swipeUp())
        val constraintLayout = onView(
            TestUtils.childAtPosition(
                Matchers.allOf(
                    withId(R.id.rvCompanies),
                    TestUtils.childAtPosition(
                        withId(R.id.parent),
                        27
                    )
                ),
                0
            )
        )
        constraintLayout.perform(click())
        onView(withId(R.id.tvName))
            .check(matches(withText("Webonise lab")))
    }
}
