package com.assignment.myresume.home.domain

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Resume(
    @SerializedName("user") @Expose val user: String,
    @SerializedName("image") @Expose val image: String,
    @SerializedName("number") @Expose val number: Int,
    @SerializedName("email") @Expose val email: String,
    @SerializedName("career_summary") @Expose val careerSummary: List<String>,
    @SerializedName("project_management_tools") @Expose val projectManagementTools: List<String>,
    @SerializedName("unit_ui_test_tools") @Expose val unitUiTestTools: List<String>,
    @SerializedName("Databases") @Expose val databases: List<String>,
    @SerializedName("operating_system") @Expose val operatingSystem: List<String>,
    @SerializedName("programming_languages") @Expose val programmingLanguages: List<String>,
    @SerializedName("scm_tool") @Expose val scmTool: List<String>,
    @SerializedName("api_tool") @Expose val apiTool: List<String>,
    @SerializedName("devops_tools") @Expose val devopsTools: List<String>,
    @SerializedName("languages") @Expose val languages: List<String>,
    @SerializedName("skill_summary") @Expose val skillSummary: List<String>,
    @SerializedName("companies") @Expose val companies: List<Company>,
    @SerializedName("education_summary") @Expose val educationSummary: List<EducationSummary>
)