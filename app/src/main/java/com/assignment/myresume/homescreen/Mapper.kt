package com.assignment.myresume.homescreen

import com.assignment.myresume.utils.Constants
import com.assignment.myresume.utils.DateTimeUtils
import java.lang.StringBuilder
import javax.inject.Inject

class Mapper @Inject constructor(
    private val dateTimeUtils: DateTimeUtils
) {
    fun map(resume: Resume): ResumeUi {
        var companiesUi = getCompaniesUi(resume.companies)
        var educationSummariesUi = getEducationSummaries(resume.educationSummary)
        return ResumeUi(
            user = resume.user,
            image = resume.image,
            number = resume.number,
            email = resume.email,
//            careerSummary = resume.careerSummary,
            careerSummary = getListAppearance(resume.careerSummary),
            projectManagementTools = getListAppearance(resume.projectManagementTools),
            unitUiTestTools = getListAppearance(resume.unitUiTestTools),
            databases = getListAppearance(resume.databases),
            operatingSystem = getListAppearance(resume.operatingSystem),
            programmingLanguages = getListAppearance(resume.programmingLanguages),
            scmTool = getListAppearance(resume.scmTool),
            apiTool = getListAppearance(resume.apiTool),
            devopsTools = getListAppearance(resume.devopsTools),
            companies = companiesUi,
            educationSummary = educationSummariesUi,
            languages = getListAppearance(resume.languages),
            skillSummary = resume.skillSummary
        )
    }

    /**
     * Function to convert company api object to company Ui object.
     */
    private fun getCompaniesUi(companies: List<Company>): List<CompanyUi> {
        var companiesUi = ArrayList<CompanyUi>()
        companies.forEach { company ->
            val companyUi = CompanyUi(
                id = company.id,
                name = company.name,
                startDate = dateTimeUtils.getFormattedDate(company.startDate),
                endDate = dateTimeUtils.getFormattedDate(company.endDate),
                data = company.data,
                logo = company.logo,
                projectCount = company.projectCount
            )
            companiesUi.add(companyUi)
        }
        return companiesUi
    }

    /**
     * Function to convert Education Summary api object to Education Summary Ui object.
     */
    private fun getEducationSummaries(summaries: List<EducationSummary>): List<EducationSummaryUi> {
        var educationSummaries = ArrayList<EducationSummaryUi>()
        summaries.forEach { edu ->
            val educationSummary = EducationSummaryUi(
                id = edu.id,
                name = edu.name,
                state = edu.state,
                country = edu.country,
                certificate = edu.certificate,
                grade = edu.grade,
                startDate = dateTimeUtils.getFormattedDate(edu.startDate),
                endDate = dateTimeUtils.getFormattedDate(edu.startDate)
            )
            educationSummaries.add(educationSummary)
        }
        return educationSummaries
    }

    fun getListAppearance(careerSummary: List<String>): String {
        val sb = StringBuilder()
        careerSummary.forEach { entry ->
            sb.apply {
                append(Constants.StringValues.DASH_SPACE)
                append(entry)
                append(Constants.StringValues.NEW_LINE)
            }
        }
        return sb.toString()
    }
}