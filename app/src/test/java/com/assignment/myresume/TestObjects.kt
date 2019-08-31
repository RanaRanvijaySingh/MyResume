package com.assignment.myresume

import com.assignment.myresume.home.domain.Resume
import com.assignment.myresume.home.ui.ResumeUi
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
    }
}