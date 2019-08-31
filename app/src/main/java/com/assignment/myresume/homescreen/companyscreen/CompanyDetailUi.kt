package com.assignment.myresume.homescreen.companyscreen

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class CompanyDetailUi(
    @SerializedName("id") @Expose val id: Int,
    @SerializedName("name") @Expose val name: String,
    @SerializedName("start_date") @Expose val startDate: String,
    @SerializedName("end_date") @Expose val endDate: String,
    @SerializedName("logo") @Expose val logo: String,
    @SerializedName("designations") @Expose val designations: List<String>,
    @SerializedName("role") @Expose val role: List<String>,
    @SerializedName("projects") @Expose val projects: List<ProjectUi>
)

data class ProjectUi(
    @SerializedName("name") @Expose val name: String,
    @SerializedName("employer") @Expose val employer: String,
    @SerializedName("technologies") @Expose val technologies: String,
    @SerializedName("operating_system") @Expose val operatingSystem: String,
    @SerializedName("domain") @Expose val domain: String,
    @SerializedName("application_link") @Expose val applicationLink: String,
    @SerializedName("project_description") @Expose val projectDescription: String,
    @SerializedName("role_and_responsibilities") @Expose val roleAndResponsibilities: List<String>
)
