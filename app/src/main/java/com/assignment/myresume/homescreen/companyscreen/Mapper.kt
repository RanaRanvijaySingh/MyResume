package com.assignment.myresume.homescreen.companyscreen

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
    fun map(companyDetail: CompanyDetail): CompanyDetailUi {
        var projectsUi = getProjectsUi(companyDetail.projects)
        return CompanyDetailUi(
            name = companyDetail.name,
            endDate = dateTimeUtils.getFormattedDate(companyDetail.endDate),
            startDate = dateTimeUtils.getFormattedDate(companyDetail.startDate),
            duration = dateTimeUtils.getDuration(companyDetail.startDate, companyDetail.endDate),
            id = companyDetail.id,
            logo = companyDetail.logo,
            designations = stringUtils.getListAppearance(companyDetail.designations),
            projects = projectsUi,
            role = stringUtils.getListAppearance(companyDetail.role)
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
                roleAndResponsibilities = stringUtils.getListAppearance(project.roleAndResponsibilities)
            )
            projectsUi.add(projectUi)
        }
        return projectsUi
    }
}