package com.assignment.myresume.homescreen.companyscreen

import com.assignment.myresume.utils.Constants
import com.assignment.myresume.utils.DateTimeUtils
import java.lang.StringBuilder
import javax.inject.Inject

class Mapper @Inject constructor(
    private val dateTimeUtils: DateTimeUtils
) {
    fun map(companyDetail: CompanyDetail): CompanyDetailUi {
        var projectsUi = getProjectsUi(companyDetail.projects)
        return CompanyDetailUi(
            name = companyDetail.name,
            endDate = dateTimeUtils.getFormattedDate(companyDetail.endDate),
            startDate = dateTimeUtils.getFormattedDate(companyDetail.startDate),
            duration = dateTimeUtils.getDuration(companyDetail.startDate, companyDetail.endDate),
            id = companyDetail.id,
            logo = companyDetail.logo,
            designations = getListAppearance(companyDetail.designations),
            projects = projectsUi,
            role = getListAppearance(companyDetail.role)
        )
    }

    /**
     * Function to convert company api object to company Ui object.
     */
    private fun getProjectsUi(projects: List<Project>): List<ProjectUi> {
        var projectsUi = ArrayList<ProjectUi>()
        projects.forEach { project ->
            val projectUi = ProjectUi(
                name = project.name,
                employer = project.employer,
                technologies = project.technologies,
                operatingSystem = project.operatingSystem,
                domain = project.domain,
                applicationLink = project.applicationLink,
                projectDescription = project.projectDescription,
                roleAndResponsibilities = project.roleAndResponsibilities
            )
            projectsUi.add(projectUi)
        }
        return projectsUi
    }

    /**
     * Function to convert a list of strings into a formatted single string
     */
    private fun getListAppearance(careerSummary: List<String>): String {
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