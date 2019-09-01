package com.assignment.myresume.homescreen.companyscreen

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

class CompanyDetailUi(
    @SerializedName("id") @Expose val id: Int,
    @SerializedName("name") @Expose val name: String,
    @SerializedName("start_date") @Expose val startDate: String,
    @SerializedName("end_date") @Expose val endDate: String,
    @SerializedName("duration") @Expose val duration: String,
    @SerializedName("logo") @Expose val logo: String,
    @SerializedName("designations") @Expose val designations: String,
    @SerializedName("role") @Expose val role: String,
    @SerializedName("projects") @Expose val projects: List<ProjectUi>
)

data class ProjectUi(
    @SerializedName("name") @Expose val name: String?,
    @SerializedName("employer") @Expose val employer: String?,
    @SerializedName("technologies") @Expose val technologies: String?,
    @SerializedName("operating_system") @Expose val operatingSystem: String?,
    @SerializedName("domain") @Expose val domain: String?,
    @SerializedName("application_link") @Expose val applicationLink: String?,
    @SerializedName("project_description") @Expose val projectDescription: String?,
    @SerializedName("role_and_responsibilities") @Expose val roleAndResponsibilities: List<String>?
) : Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.createStringArrayList()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeString(employer)
        writeString(technologies)
        writeString(operatingSystem)
        writeString(domain)
        writeString(applicationLink)
        writeString(projectDescription)
        writeStringList(roleAndResponsibilities)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ProjectUi> = object : Parcelable.Creator<ProjectUi> {
            override fun createFromParcel(source: Parcel): ProjectUi = ProjectUi(source)
            override fun newArray(size: Int): Array<ProjectUi?> = arrayOfNulls(size)
        }
    }
}
