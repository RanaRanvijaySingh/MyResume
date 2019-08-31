package com.assignment.myresume

import com.assignment.myresume.homescreen.Resume
import com.assignment.myresume.homescreen.ResumeUi
import com.assignment.myresume.homescreen.companiesscreen.CompanyDetail
import com.assignment.myresume.homescreen.companiesscreen.CompanyDetailUi
import com.google.gson.GsonBuilder

/**
 * Class to provide objects that can be directly used in testing.
 */
class TestObjects {
    companion object {
        val gson = GsonBuilder().create()

        val resume = gson.fromJson(
            JsonReaderUtil.readJsonFile(this.javaClass.classLoader!!
                .getResourceAsStream("resume.json")),
            Resume::class.java
        )

        val resumeUi = gson.fromJson(
            JsonReaderUtil.readJsonFile(this.javaClass.classLoader!!
                .getResourceAsStream("resumeui.json")),
            ResumeUi::class.java
        )

        val companyDetail = gson.fromJson(
            JsonReaderUtil.readJsonFile(this.javaClass.classLoader!!
                .getResourceAsStream("globant.json")),
            CompanyDetail::class.java
        )

        val companyDetailUi = gson.fromJson(
            JsonReaderUtil.readJsonFile(this.javaClass.classLoader!!
                .getResourceAsStream("globantui.json")),
            CompanyDetailUi::class.java
        )
    }
}