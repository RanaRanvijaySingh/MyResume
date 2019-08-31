package com.assignment.myresume.home.data

import com.assignment.myresume.home.domain.Resume
import com.assignment.myresume.service.ResumeService
import io.reactivex.Flowable
import javax.inject.Inject

class ResumeRepository @Inject constructor(
    private val resumeService: ResumeService
) {
    fun getResume(): Flowable<Resume> {
        return resumeService.getResume()
    }
}