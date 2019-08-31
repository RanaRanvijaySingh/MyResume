package com.assignment.myresume.home.domain

data class ResumeUi(
    val user: String,
    val image: String,
    val number: Long,
    val email: String,
    val careerSummary: List<String>,
    val projectManagementTools: List<String>,
    val unitUiTestTools: List<String>,
    val databases: List<String>,
    val operatingSystem: List<String>,
    val programmingLanguages: List<String>,
    val scmTool: List<String>,
    val apiTool: List<String>,
    val devopsTools: List<String>,
    val languages: List<String>,
    val skillSummary: List<String>,
    val companies: List<Company>,
    val educationSummary: List<EducationSummary>
)