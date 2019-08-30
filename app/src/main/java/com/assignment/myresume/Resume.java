package com.assignment.myresume;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Resume {

    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("number")
    @Expose
    private Integer number;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("career_summary")
    @Expose
    private List<String> careerSummary = null;
    @SerializedName("project_management_tools")
    @Expose
    private List<String> projectManagementTools = null;
    @SerializedName("unit_ui_test_tools")
    @Expose
    private List<String> unitUiTestTools = null;
    @SerializedName("Databases")
    @Expose
    private List<String> databases = null;
    @SerializedName("operating_system")
    @Expose
    private List<String> operatingSystem = null;
    @SerializedName("programming_languages")
    @Expose
    private List<String> programmingLanguages = null;
    @SerializedName("scm_tool")
    @Expose
    private List<String> scmTool = null;
    @SerializedName("api_tool")
    @Expose
    private List<String> apiTool = null;
    @SerializedName("devops_tools")
    @Expose
    private List<String> devopsTools = null;
    @SerializedName("languages")
    @Expose
    private List<String> languages = null;
    @SerializedName("skill_summary")
    @Expose
    private List<String> skillSummary = null;
    @SerializedName("companies")
    @Expose
    private List<Company> companies = null;
    @SerializedName("education_summary")
    @Expose
    private List<EducationSummary> educationSummary = null;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getCareerSummary() {
        return careerSummary;
    }

    public void setCareerSummary(List<String> careerSummary) {
        this.careerSummary = careerSummary;
    }

    public List<String> getProjectManagementTools() {
        return projectManagementTools;
    }

    public void setProjectManagementTools(List<String> projectManagementTools) {
        this.projectManagementTools = projectManagementTools;
    }

    public List<String> getUnitUiTestTools() {
        return unitUiTestTools;
    }

    public void setUnitUiTestTools(List<String> unitUiTestTools) {
        this.unitUiTestTools = unitUiTestTools;
    }

    public List<String> getDatabases() {
        return databases;
    }

    public void setDatabases(List<String> databases) {
        this.databases = databases;
    }

    public List<String> getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(List<String> operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public List<String> getProgrammingLanguages() {
        return programmingLanguages;
    }

    public void setProgrammingLanguages(List<String> programmingLanguages) {
        this.programmingLanguages = programmingLanguages;
    }

    public List<String> getScmTool() {
        return scmTool;
    }

    public void setScmTool(List<String> scmTool) {
        this.scmTool = scmTool;
    }

    public List<String> getApiTool() {
        return apiTool;
    }

    public void setApiTool(List<String> apiTool) {
        this.apiTool = apiTool;
    }

    public List<String> getDevopsTools() {
        return devopsTools;
    }

    public void setDevopsTools(List<String> devopsTools) {
        this.devopsTools = devopsTools;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getSkillSummary() {
        return skillSummary;
    }

    public void setSkillSummary(List<String> skillSummary) {
        this.skillSummary = skillSummary;
    }

    public List<Company> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }

    public List<EducationSummary> getEducationSummary() {
        return educationSummary;
    }

    public void setEducationSummary(List<EducationSummary> educationSummary) {
        this.educationSummary = educationSummary;
    }

}