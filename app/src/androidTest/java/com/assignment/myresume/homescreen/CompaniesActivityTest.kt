@file:Suppress("DEPRECATION")

package com.assignment.myresume.homescreen

import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.registerIdlingResources
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.assignment.myresume.R
import com.assignment.myresume.homescreen.companyscreen.CompanyActivity
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class CompaniesActivityTest {

    @get:Rule
    var rule = ActivityTestRule(CompanyActivity::class.java)

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

        val textView = onView(
            Matchers.allOf(
                withId(R.id.tvCompany), withText("Webonise lab"),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(ViewGroup::class.java), 0
                    ), 0
                ),
                isDisplayed()
            )
        )
        textView.check(matches(withText("Webonise lab")))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
