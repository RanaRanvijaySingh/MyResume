package com.assignment.myresume.homescreen.testutils

import android.view.View
import android.view.ViewGroup
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.TypeSafeMatcher

class TestUtils {
    class StringValues {
        companion object {
            const val CARRIER_SUMMARY = "CARRIER SUMMARY"
            const val SUMMARY_OF_QUALIFICATIONS = "Summary of Qualifications"
            const val PROJECT_MANAGEMENT_TOOLS = "Project management tools"
            const val UI_TESTING = "Unit / UI Test Tools"
            const val DATABASES = "databases"
            const val OPERATING_SYSTEM = "Operating System"
            const val PROGRAMMING_LANGUAGE = "Programming languages"
            const val DEVOPS_TOOLS = "Devops tools"
            const val API_TOOLS = "Api tools"
            const val SCM_TOOLS = "Scm Tools"
            const val LANGUAGES = "Speak Languages"
            const val SUMMARY_OF_SKILLS = "Summary of skills"
            const val COMPANIES_WORKED_WITH = "companies worked with"

            const val DESIGNATION = "DESIGNATION"
            const val ROLES_AND_RESPONSIBILITIES = "ROLES AND RESPONSIBILITY"
        }
    }

    companion object {
        fun childAtPosition(
            parentMatcher: Matcher<View>,
            position: Int
        ): Matcher<View> {

            return object : TypeSafeMatcher<View>() {
                override fun describeTo(description: Description) {
                    description.appendText("Child at position $position in parent ")
                    parentMatcher.describeTo(description)
                }

                public override fun matchesSafely(view: View): Boolean {
                    val parent = view.parent
                    return parent is ViewGroup && parentMatcher.matches(parent) &&
                            view == parent.getChildAt(position)
                }
            }
        }
    }
}