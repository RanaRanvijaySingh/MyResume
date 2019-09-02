package com.assignment.myresume.homescreen

import com.assignment.myresume.utils.DateTimeUtils
import com.assignment.myresume.utils.StringUtils
import javax.inject.Inject

/**
 * Class to handle all the heavy conversion.
 * ie. Converting API model to UI model
 */
class Mapper @Inject constructor(
    private val dateTimeUtils: DateTimeUtils,
    private val stringUtils: StringUtils
) {
    /**
     * Function to convert API model to UI model
     */
    fun map(resume: Resume): ResumeUi {
        var companiesUi = getCompaniesUi(resume.companies)
        var educationSummariesUi = getEducationSummaries(resume.educationSummary)
        return ResumeUi(
            user = resume.user,
            image = resume.image,
            number = resume.number,
            email = resume.email,
            careerSummary = stringUtils.getListAppearance(resume.careerSummary),
            projectManagementTools = stringUtils.getListAppearance(resume.projectManagementTools),
            unitUiTestTools = stringUtils.getListAppearance(resume.unitUiTestTools),
            databases = stringUtils.getListAppearance(resume.databases),
            operatingSystem = stringUtils.getListAppearance(resume.operatingSystem),
            programmingLanguages = stringUtils.getListAppearance(resume.programmingLanguages),
            scmTool = stringUtils.getListAppearance(resume.scmTool),
            apiTool = stringUtils.getListAppearance(resume.apiTool),
            devopsTools = stringUtils.getListAppearance(resume.devopsTools),
            companies = companiesUi,
            educationSummary = educationSummariesUi,
            languages = stringUtils.getListAppearance(resume.languages),
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