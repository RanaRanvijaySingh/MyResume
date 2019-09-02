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
import com.assignment.myresume.homescreen.testutils.TestObjects
import com.assignment.myresume.homescreen.testutils.TestUtils
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
    val resumeUi: ResumeUi = TestObjects.resumeUi

    @Test
    fun testUserName() {
        /** We can grab the screenshots using fastlane's screengrab tool.
        Screengrab.screenshot("testCompanyName") **/
        registerIdlingResources(rule.activity.idleResource)
        onView(withId(R.id.tvName))
            .check(matches(withText("Rana Ranvijay Singh")))
    }

    @Test
    fun testCarrierSummaryTitle() {
        onView(withId(R.id.tvCareerSummaryTitle))
            .check(matches(withText(TestUtils.StringValues.CARRIER_SUMMARY.toUpperCase())))
    }

    @Test
    fun testQualificationSummaryTitle() {
        onView(withId(R.id.tvQualificationSummaryTitle))
            .check(matches(withText(TestUtils.StringValues.SUMMARY_OF_QUALIFICATIONS.toUpperCase())))
    }

    @Test
    fun testProjectManagementToolsTitle() {
        onView(withId(R.id.tvProjectManagementToolsTitle))
            .check(matches(withText(TestUtils.StringValues.PROJECT_MANAGEMENT_TOOLS.toUpperCase())))
    }

    @Test
    fun testTestingTitle() {
        onView(withId(R.id.tvTestingTitle))
            .check(matches(withText(TestUtils.StringValues.UI_TESTING.toUpperCase())))
    }

    @Test
    fun testDatabasesTitle() {
        onView(withId(R.id.tvDatabasesTitle))
            .check(matches(withText(TestUtils.StringValues.DATABASES.toUpperCase())))
    }

    @Test
    fun testOsTitle() {
        onView(withId(R.id.tvOsTitle))
            .check(matches(withText(TestUtils.StringValues.OPERATING_SYSTEM.toUpperCase())))
    }

    @Test
    fun testProgrammingLanguageTitle() {
        onView(withId(R.id.tvProgrammingLanguageTitle))
            .check(matches(withText(TestUtils.StringValues.PROGRAMMING_LANGUAGE.toUpperCase())))
    }

    @Test
    fun testDevopsToolTitle() {
        onView(withId(R.id.tvDevopsToolTitle))
            .check(matches(withText(TestUtils.StringValues.DEVOPS_TOOLS.toUpperCase())))
    }

    @Test
    fun testtvApiToolTitle() {
        onView(withId(R.id.tvApiToolTitle))
            .check(matches(withText(TestUtils.StringValues.API_TOOLS.toUpperCase())))
    }

    @Test
    fun testScmToolTitle() {
        onView(withId(R.id.tvScmToolTitle))
            .check(matches(withText(TestUtils.StringValues.SCM_TOOLS.toUpperCase())))
    }

    @Test
    fun testLanguagesTitle() {
        onView(withId(R.id.tvLanguagesTitle))
            .check(matches(withText(TestUtils.StringValues.LANGUAGES.toUpperCase())))
    }

    @Test
    fun testSkillsTitle() {
        onView(withId(R.id.tvSkillsTitle))
            .check(matches(withText(TestUtils.StringValues.SUMMARY_OF_SKILLS.toUpperCase())))
    }

    @Test
    fun testCompaniesTitle() {
        onView(withId(R.id.tvCompaniesTitle))
            .check(matches(withText(TestUtils.StringValues.COMPANIES_WORKED_WITH.toUpperCase())))
    }

    // Test for values
    @Test
    fun testCarrierSummary() {
        onView(withId(R.id.tvCareerSummary))
            .check(matches(withText(resumeUi.careerSummary)))
    }

    @Test
    fun testProjectManagementTools() {
        onView(withId(R.id.tvProjectManagementTools))
            .check(matches(withText(resumeUi.projectManagementTools)))
    }

    @Test
    fun testTesting() {
        onView(withId(R.id.tvTestingTools))
            .check(matches(withText(resumeUi.unitUiTestTools)))
    }

    @Test
    fun testDatabases() {
        onView(withId(R.id.tvDatabases))
            .check(matches(withText(resumeUi.databases)))
    }

    @Test
    fun testOs() {
        onView(withId(R.id.tvOs))
            .check(matches(withText(resumeUi.operatingSystem)))
    }

    @Test
    fun testProgrammingLanguage() {
        onView(withId(R.id.tvProgrammingLanguage))
            .check(matches(withText(resumeUi.programmingLanguages)))
    }

    @Test
    fun testDevopsTool() {
        onView(withId(R.id.tvDevopsTool))
            .check(matches(withText(resumeUi.devopsTools)))
    }

    @Test
    fun testApiTool() {
        onView(withId(R.id.tvApiTool))
            .check(matches(withText(resumeUi.apiTool)))
    }

    @Test
    fun testScmTool() {
        onView(withId(R.id.tvScmTool))
            .check(matches(withText(resumeUi.scmTool)))
    }

    @Test
    fun testLanguages() {
        onView(withId(R.id.tvLanguages))
            .check(matches(withText(resumeUi.languages)))
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
        /** We can grab the screenshots using fastlane's screengrab tool.
        Screengrab.screenshot("testCompanyName") **/
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
