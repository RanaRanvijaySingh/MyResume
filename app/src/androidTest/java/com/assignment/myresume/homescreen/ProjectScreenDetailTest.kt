package com.assignment.myresume.homescreen


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.scrollTo
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.assignment.myresume.R
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.hamcrest.core.IsInstanceOf
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class ProjectScreenDetailTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun projectScreenDetailTest() {
        val constraintLayout = onView(
            childAtPosition(
                allOf(withId(R.id.rvCompanies),
                    childAtPosition(
                        withId(R.id.parent),
                        27)),
                2))
        constraintLayout.perform(scrollTo(), click())

        Thread.sleep(3000)

        val appCompatButton = onView(
            allOf(withId(R.id.btnProject), withText("projects"),
                childAtPosition(
                    allOf(withId(R.id.parent),
                        childAtPosition(
                            withId(android.R.id.content),
                            0)),
                    2),
                isDisplayed()))
        appCompatButton.perform(click())

        Thread.sleep(3000)

        val textView = onView(
            allOf(withId(R.id.tvName), withText("FCV (Android Application)"),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.widget.ScrollView::class.java),
                        0),
                    0),
                isDisplayed()))
        textView.check(matches(withText("FCV (Android Application)")))

        val textView2 = onView(
            allOf(withId(R.id.tvEmployer), withText("Employer: Cannot disclose"),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.widget.ScrollView::class.java),
                        0),
                    1),
                isDisplayed()))
        textView2.check(matches(withText("Employer: Cannot disclose")))

        val textView3 = onView(
            allOf(withId(R.id.tvTechnology), withText("Technology: Kotlin"),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.widget.ScrollView::class.java),
                        0),
                    2),
                isDisplayed()))
        textView3.check(matches(withText("Technology: Kotlin")))

        val textView4 = onView(
            allOf(withId(R.id.tvDomain), withText("Domain: Banking"),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.widget.ScrollView::class.java),
                        0),
                    4),
                isDisplayed()))
        textView4.check(matches(withText("Domain: Banking")))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int): Matcher<View> {

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
