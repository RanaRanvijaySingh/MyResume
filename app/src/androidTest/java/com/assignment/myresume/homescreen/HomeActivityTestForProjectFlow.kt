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
class HomeActivityTestForProjectFlow {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun homeActivityTest3() {
        Thread.sleep(3000)
        val constraintLayout = onView(
            childAtPosition(
                allOf(
                    withId(R.id.rvCompanies),
                    childAtPosition(
                        withId(R.id.parent),
                        27
                    )
                ),
                0
            )
        )
        constraintLayout.perform(scrollTo(), click())

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(3000)

        val appCompatImageButton = onView(
            allOf(
                withContentDescription("Navigate up"),
                childAtPosition(
                    allOf(
                        withId(R.id.toolbar),
                        childAtPosition(
                            withId(R.id.appbar),
                            0
                        )
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        appCompatImageButton.perform(click())

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(3000)

        val constraintLayout2 = onView(
            childAtPosition(
                allOf(
                    withId(R.id.rvCompanies),
                    childAtPosition(
                        withId(R.id.parent),
                        27
                    )
                ),
                2
            )
        )
        constraintLayout2.perform(scrollTo(), click())

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(3000)

        val appCompatButton = onView(
            allOf(
                withId(R.id.btnProject), withText("projects"),
                childAtPosition(
                    allOf(
                        withId(R.id.parent),
                        childAtPosition(
                            withId(android.R.id.content),
                            0
                        )
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        appCompatButton.perform(click())

        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        Thread.sleep(3000)

        val textView = onView(
            allOf(
                withId(R.id.tvName), withText("FCV (Android Application)"),
                childAtPosition(
                    childAtPosition(
                        IsInstanceOf.instanceOf(android.widget.ScrollView::class.java),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textView.check(matches(withText("FCV (Android Application)")))
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
