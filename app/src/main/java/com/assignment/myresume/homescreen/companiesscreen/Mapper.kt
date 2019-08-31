package com.assignment.myresume.homescreen.companiesscreen

import com.assignment.myresume.utils.DateTimeUtils
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
            id = companyDetail.id,
            logo = companyDetail.logo,
            designations = companyDetail.designations,
            projects = projectsUi,
            role = companyDetail.role
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
}