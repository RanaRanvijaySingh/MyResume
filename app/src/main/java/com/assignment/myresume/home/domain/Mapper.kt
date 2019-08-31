package com.assignment.myresume.home.domain

import com.assignment.myresume.home.ui.CompanyUi
import com.assignment.myresume.home.ui.EducationSummaryUi
import com.assignment.myresume.home.ui.ResumeUi
import com.assignment.myresume.utils.DateTimeUtils
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
            careerSummary = resume.careerSummary,
            projectManagementTools = resume.projectManagementTools,
            unitUiTestTools = resume.unitUiTestTools,
            databases = resume.databases,
            operatingSystem = resume.operatingSystem,
            programmingLanguages = resume.programmingLanguages,
            scmTool = resume.scmTool,
            apiTool = resume.apiTool,
            devopsTools = resume.devopsTools,
            companies = companiesUi,
            educationSummary = educationSummariesUi,
            languages = resume.languages,
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
}