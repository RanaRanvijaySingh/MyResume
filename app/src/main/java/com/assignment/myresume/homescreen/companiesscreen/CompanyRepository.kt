package com.assignment.myresume.homescreen.companiesscreen

import com.assignment.myresume.service.ResumeService
import io.reactivex.Flowable
import javax.inject.Inject

class CompanyRepository @Inject constructor(
    private val resumeService: ResumeService
) {
    fun getCompany(url: String): Flowable<CompanyDetail> {
        return resumeService.getCompany(url)
    }
}