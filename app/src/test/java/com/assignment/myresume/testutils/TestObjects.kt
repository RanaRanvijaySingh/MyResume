package com.assignment.myresume.testutils

import com.assignment.myresume.homescreen.Resume
import com.assignment.myresume.homescreen.ResumeUi
import com.assignment.myresume.homescreen.companyscreen.CompanyDetail
import com.assignment.myresume.homescreen.companyscreen.CompanyDetailUi
import com.google.gson.GsonBuilder

/**
 * Class to provide objects that can be directly used in testing.
 */
class TestObjects {
    companion object {
        val companyUrl: String = "b03778260d79c4f0d9c31776a3b7d3f8/raw/b802f11336617452c9905408f130adc7ab2ade85/globant"
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