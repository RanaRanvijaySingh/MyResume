package com.assignment.myresume.home.domain

import javax.inject.Inject

class Mapper @Inject constructor() {
    fun map(resume: Resume): ResumeUi {
        return ResumeUi(
            resume.user,
            resume.image,
            resume.number,
            resume.email,
            resume.careerSummary,
            resume.projectManagementTools,
            resume.unitUiTestTools,
            resume.databases,
            resume.operatingSystem,
            resume.programmingLanguages,
            resume.scmTool,
            resume.apiTool,
            resume.devopsTools,
            resume.programmingLanguages,
            resume.skillSummary,
            resume.companies,
            resume.educationSummary
        )
    }
}